package com.noobdevs.examples;


public class ThreadLocalBasicRemovalExample {

    private final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Default");

    public ThreadLocalBasicRemovalExample() {

    }

    Thread thread_1 = new Thread(() -> {
        threadLocal.set("Hal Jordan");
        String value = threadLocal.get();
        System.out.println("Thread 1 : " + value);

        threadLocal.remove();

        value = threadLocal.get();
        System.out.println("Thread 1 : " + value);
    });

    Thread thread_2 = new Thread(() -> {
        threadLocal.set("John Stewart");
        String value = threadLocal.get();
        System.out.println("Thread 2 : " + value);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }

        String val_2 = threadLocal.get();
        System.out.println("Thread 2 : " + val_2);

        threadLocal.remove();

        String val_3 = threadLocal.get();
        System.out.println("Thread 3 : " + val_3);
    });

    public static void main(String[] args) {
        ThreadLocalBasicRemovalExample removalExample =
                new ThreadLocalBasicRemovalExample();

        removalExample.thread_1.start();
        System.out.println();
        removalExample.thread_2.start();
    }

}
