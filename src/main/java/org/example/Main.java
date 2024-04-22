package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        BlockingQueue blockingQueue = new BlockingQueue();


        for (int i = 0; i < 10; i++) {
            blockingQueue.enqueue(new RandomNumbers());
            executorService.execute(blockingQueue.dequeue());
        }
        executorService.shutdown();

    }
}
