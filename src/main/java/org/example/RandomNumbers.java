package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RandomNumbers extends Thread{

    private final String str = "Случайная цифра равна:";

    public RandomNumbers() {}

    public void run() {
        System.out.println(str + "\n" + (int) (Math.random() * 100));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
