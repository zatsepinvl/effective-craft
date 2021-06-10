package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
