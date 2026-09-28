package com.noobdevs.exercises;

import java.util.concurrent.BlockingQueue;

public class MyPoolThreadRunnable implements Runnable{

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public MyPoolThreadRunnable(BlockingQueue queue) {
        this.taskQueue = queue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();;
            } catch(Exception e) {
                System.out.println("Something went wrong");
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return this.isStopped;
    }
}
