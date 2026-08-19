package com.noobdevs.virtual_thread;

public class VirtualThreadExample {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index: " + i);
            }
        };

        Thread vThread_1 = Thread.ofVirtual().start(runnable);

        Thread vThread_Unstarted = Thread.ofVirtual().unstarted(runnable);

        vThread_Unstarted.start();

        try {
            vThread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
