package com.noobdevs.thread_local;


public class ThreadInheritableLocalExample {

    private ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Default");
    private InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    Thread thread1 = new Thread(() -> {
        System.out.println("========== Thread 1 ==========");
        threadLocal.set("Son Goku");
        inheritableThreadLocal.set("Saiyan");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Parent Name : " + threadLocal.get());
        System.out.println("Race : " + inheritableThreadLocal.get());

        Thread innerThread = new Thread(() -> {
            System.out.println("========== Child Thread =========");
            System.out.println("Name : " + threadLocal.get());
            System.out.println("Race : " + inheritableThreadLocal.get());
        });

        innerThread.start();
    });

    static void main() {
        ThreadInheritableLocalExample inheritableLocalExample =
                new ThreadInheritableLocalExample();

        inheritableLocalExample.thread1.start();
    }
}