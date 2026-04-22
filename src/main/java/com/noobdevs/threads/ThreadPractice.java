package com.noobdevs.threads;

public class ThreadPractice {

    static void main() {
        Thread t_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in this current thread: " + Thread.currentThread().getName());
            }
        });

        t_1.setName("SWAMP IZZO THREAD");

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        t_1.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
