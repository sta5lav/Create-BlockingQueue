package org.example;

import java.util.ArrayList;

class BlockingQueue{

    private ArrayList<Runnable> array = new ArrayList<>();

    public synchronized void enqueue(Runnable task) {
        array.add(task);
        notify();
    }

    public synchronized Runnable dequeue() throws InterruptedException {
        if (array.isEmpty()) {
            wait();
        }
        Runnable runnable = array.get(0);
        array.remove(runnable);
        return runnable;
    }



}
