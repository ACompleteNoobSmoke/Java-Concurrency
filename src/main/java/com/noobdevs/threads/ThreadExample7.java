package com.noobdevs.threads;

public class ThreadExample7 {

    static void main() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running!");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " finished!");

        };

        Thread thead = new Thread(runnable, "Based Thread");
        thead.start();
    }
}
