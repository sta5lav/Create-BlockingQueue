package org.example;

public class RandomNumbers extends Thread{

    private final String str = "Случайная цифра равна:";

    public RandomNumbers() {}

    public void run() {
        System.out.println(str + "\n" + (int) (Math.random() * 100));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n");
    }
}
