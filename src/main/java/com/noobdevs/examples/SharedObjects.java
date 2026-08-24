package com.noobdevs.examples;

public class SharedObjects {

    static void main() {
        MyRunnable runnable = new MyRunnable();

        Thread thread_1 = new Thread(runnable, "Thread 1");
        Thread thread_2 = new Thread(runnable, "Thread 2");

        thread_1.start();
        thread_2.start();
    }
}
