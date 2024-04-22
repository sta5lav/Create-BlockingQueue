package org.example;

import java.util.ArrayList;

class BlockingQueue {

    private final ArrayList<Runnable> array = new ArrayList<>(2);

    public synchronized void enqueue(Runnable task) {
        if (array.size() == 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        array.add(task);
        notify();
    }

    public synchronized Runnable dequeue(){
        while (array.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Runnable runnable = array.get(0);
        array.remove(runnable);
        return runnable;
    }

    public Integer size() {
        return array.size();
    }



}
