package concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SharedRecycledObjectPool {

    static class SharedObject {
        private final int id;
        private static final Random rnd = new Random();

        SharedObject(int id) {
            this.id = id;
        }

        public void execute() throws InterruptedException {
            Thread.sleep(1000);
            //System.out.println("executed " + id);
        }

        public void close() {
            //System.out.println("closed " + id);
        }

        @Override
        public String toString() {
            return "SharedObject{" +
                    "id=" + id +
                    '}';
        }
    }

    static class SharedObjectFactory {
        private final AtomicInteger newCounter = new AtomicInteger(0);

        public SharedObject createInstance() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new SharedObject(newCounter.getAndIncrement());
        }
    }

    private final BlockingQueue<SharedObject> queue = new LinkedBlockingQueue<>();
    private final ConcurrentMap<SharedObject, Long> objectExpirations = new ConcurrentHashMap<>();
    private final ConcurrentMap<SharedObject, Integer> recycleBin = new ConcurrentHashMap<>();
    private final SharedObjectFactory objectFactory;
    private final long expirationRateSec;
    private final long parallelism;

    public SharedRecycledObjectPool(
            int poolSize,
            int parallelism,
            long expirationRateSec,
            long recycleRateSec,
            SharedObjectFactory objectFactory,
            ScheduledExecutorService executor
    ) {
        this.parallelism = parallelism;
        this.expirationRateSec = expirationRateSec;
        this.objectFactory = objectFactory;

        fillQueue(poolSize);

        executor.scheduleAtFixedRate(() -> {
            List<SharedObject> list = new ArrayList<>(poolSize * parallelism);
            queue.drainTo(list, poolSize * parallelism);
            list.forEach(obj -> {
                if (!recycle(obj)) {
                    queue.add(obj);
                }
            });
            recycleBin.forEach((obj, i) -> {
                fillQueue(1);
                if (i == parallelism) {
                    obj.close();
                    recycleBin.remove(obj);
                }
            });
        }, recycleRateSec, recycleRateSec, TimeUnit.SECONDS);
    }

    private void fillQueue(int n) {
        for (int i = 0; i < n; i++) {
            var object = objectFactory.createInstance();
            var now = System.currentTimeMillis();
            objectExpirations.put(object, now + (i + 1) * TimeUnit.SECONDS.toMillis(expirationRateSec));
            for (int j = 0; j < parallelism; j++) {
                queue.add(object);
            }
        }
    }

    public SharedObject acquire() throws InterruptedException {
        SharedObject object = queue.take();
        while (recycle(object)) {
            object = queue.take();
        }
        return object;
    }

    private boolean recycle(SharedObject object) {
        if (objectExpirations.get(object) <= System.currentTimeMillis()) {
            recycleBin.merge(object, 1, Integer::sum);
            return true;
        }
        return false;
    }

    public void release(SharedObject object) {
        queue.add(object);
    }

    public static void main(String[] args) throws InterruptedException {
        var factory = new SharedObjectFactory();
        var pool = new SharedRecycledObjectPool(
                3,
                3,
                10,
                5,
                factory,
                Executors.newScheduledThreadPool(2)
        );

        int n = 30;

        AtomicLong executions = new AtomicLong();
        long start = System.currentTimeMillis();
        Runnable task = () -> {
            try {
                while (true) {
                    var obj = pool.acquire();
                    obj.execute();
                    pool.release(obj);
                    long count = executions.incrementAndGet();
                    long end = (System.currentTimeMillis() - start) / 1000;
                    System.out.println("Execution rate: " + ((double) count / (double) end));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        var executor = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            executor.submit(task);
        }
        Thread.sleep(100000000);
    }
}
