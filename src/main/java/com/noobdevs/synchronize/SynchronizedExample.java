package com.noobdevs.synchronize;

public class SynchronizedExample {

    public void method_1() {
        synchronized (this) {
            System.out.println("Hello");
        }
    }

    public synchronized void method_2() {
        System.out.println("Hello");
    }

    public static void method_3() {
        synchronized (SynchronizedExample.class) {
            System.out.println("Hello");
        }
    }

    public static synchronized void method_4() {
        System.out.println("Hello");
    }
}
