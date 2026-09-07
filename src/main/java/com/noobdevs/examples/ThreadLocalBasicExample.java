package com.noobdevs.examples;

import javax.swing.plaf.TableHeaderUI;

public class ThreadLocalBasicExample {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    Thread thread1 = new Thread(() -> {
        threadLocal.set("Thread 1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String value = threadLocal.get();
        System.out.println(value);
    });

    Thread thread2 = new Thread(() -> {
        threadLocal.set("Thread 2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String value = threadLocal.get();
        System.out.println(value);
    });

    static void main() {
        ThreadLocalBasicExample threadLocalBasicExample = new ThreadLocalBasicExample();
        threadLocalBasicExample.thread1.start();
        threadLocalBasicExample.thread2.start();
    }
}
