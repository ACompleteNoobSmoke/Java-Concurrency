package com.noobdevs.threads;

public class ThreadExample5 {

    static void main() {
        Runnable runnable = () -> {
            System.out.println("Lambda running");
            System.out.println("Lambda finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
