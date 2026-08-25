package com.noobdevs.synchronize;

public class SynchronizedExchangerMain {

    public static void main(String[] args) {
        SynchronizedExchanger exchanger = new SynchronizedExchanger();

        Thread thread_1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            exchanger.setObject("" + i);
                        }
                    }
                }
        );

        Thread thread_2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + exchanger.getObject());
                        }
                    }
                },

                "Thread 2"
        );

        thread_1.start();
        thread_2.start();
    }
}
