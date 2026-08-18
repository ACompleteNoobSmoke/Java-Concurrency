package com.noobdevs.threads;

public class ThreadExample6 {

    static void main() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running!");
        };

        Thread thread = new Thread(runnable, "Based Thread");
        thread.start();

        Thread thread_2 = new Thread(runnable, "Based Thread 2");
        thread_2.start();

        Thread thread_3 = new Thread(runnable, "Based Thread 3");
        thread_3.start();



    }
}
