package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {

    boolean value = false;

    public void run() throws InterruptedException {
        synchronized (this) {
            while (value) {
                System.out.println(Thread.currentThread()+": wait");
                this.wait();
            }
            System.out.println(Thread.currentThread()+": set value");
            value = true;
            value = false;
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var example = new SynchronizedExample();
        int n = 2;
        var executor = Executors.newFixedThreadPool(n);
        var barrier = new CyclicBarrier(n);

        Runnable task = () -> {
            try {
                barrier.await();
                example.run();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < n; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }
}
