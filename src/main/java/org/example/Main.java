package org.example;



import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        BlockingQueue blockingQueue = new BlockingQueue();

        //for example
        for (int i = 0; i < 10; i++) {
            blockingQueue.enqueue(new RandomNumbers());
            executorService.execute(blockingQueue.dequeue());
        }

        executorService.shutdown();

    }


}
