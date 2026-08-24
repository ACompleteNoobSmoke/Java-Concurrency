package com.noobdevs.examples;

import com.noobdevs.threads.ThreadExample2;

public class SeperateObjects {

    static void main() {
        MyRunnable runnable = new MyRunnable();
        MyRunnable runnable_2 = new MyRunnable();

        Thread thread_1 = new Thread(runnable, "Thread 1");
        Thread thread_2 = new Thread(runnable_2, "Thread 2");

        thread_1.start();
        thread_2.start();
    }
}
