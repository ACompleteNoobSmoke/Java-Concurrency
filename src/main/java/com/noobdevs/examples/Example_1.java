package com.noobdevs.examples;

public class Example_1 {

    public void simpleThread() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread_1 = new Thread(runnable, "The Thread 1");
        Thread thread_2 = new Thread(runnable, "The Thread 2");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread_1.start();
        thread_2.start();
    }

    static void main() {
        Example_1 example_1 = new Example_1();
        example_1.simpleThread();
    }
}
