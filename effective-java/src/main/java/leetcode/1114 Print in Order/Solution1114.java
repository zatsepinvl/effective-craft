import java.util.concurrent.*;

public class Solution1114 {
    public static void main(String[] args) throws InterruptedException {

        Phaser phaser1 = new Phaser(4);
        Phaser phaser2 = new Phaser(1);
        Semaphore semaphore = new Semaphore(2);
        semaphore.release();
        synchronized (phaser1) {

        }
        new Thread(() -> {
            phaser2.arriveAndAwaitAdvance();
            System.out.println("second");
            phaser1.arriveAndAwaitAdvance();
        }).start();
        new Thread(() -> {
            phaser2.arriveAndAwaitAdvance();
            System.out.println("first");
            phaser1.arriveAndAwaitAdvance();
        }).start();

        new Thread(() -> {
            phaser2.arriveAndAwaitAdvance();
            System.out.println("third");
            phaser1.arriveAndAwaitAdvance();
        }).start();

        new Thread(() -> {
            phaser2.arriveAndAwaitAdvance();
            System.out.println("fourth");
            phaser1.arriveAndAwaitAdvance();
        }).start();
        phaser1.arriveAndAwaitAdvance();
    }
}