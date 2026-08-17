package com.noobdevs.threads;

public class ThreadExample2 {

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread running");
            System.out.println(MyThread.class.getSimpleName() + " finished");
        }
    }

    static void main() {
        MyThread thread = new MyThread();
        thread.start();
    }
}
