package com.noobdevs.threads;

public class ThreadPractice {

    static void main() {
        //exercise1();
        //exercise2();
        SwampIzzoThread swampIzzoThread = new SwampIzzoThread("BASED");
        swampIzzoThread.start();
    }

    private static void exercise1() {
        Thread t_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in this current thread: " + Thread.currentThread().getName());
            }
        });

        t_1.setName("SWAMP IZZO THREAD");
        t_1.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        t_1.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }

    private static void exercise2() {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("Misbehaving Thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });

        thread.start();
    }
}
