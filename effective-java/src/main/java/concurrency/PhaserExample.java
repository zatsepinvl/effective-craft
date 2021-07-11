package concurrency;

import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        List<Runnable> tasks = List.of(
                () -> System.out.println("Task 1"),
                () -> System.out.println("Task 2"),
                () -> System.out.println("Task 3"),
                () -> System.out.println("Task 4")
        );
        Phaser startingGate = new Phaser(1); // "1" to register self
        // create and start threads
        for (Runnable task : tasks) {
            startingGate.register();
            new Thread(() -> {
                System.out.println("arrived");
                startingGate.arriveAndAwaitAdvance();
                task.run();
            }).start();
        }

        // deregister self to allow threads to proceed
        startingGate.arriveAndDeregister();
    }
}
