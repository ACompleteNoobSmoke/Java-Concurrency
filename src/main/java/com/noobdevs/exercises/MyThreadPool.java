package com.noobdevs.exercises;

import com.noobdevs.thread_pool.PoolThreadRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;
    private List<MyPoolThreadRunnable> runnables = null;
    private boolean isStopped = false;

    public MyThreadPool(int numberOfThreads, int maxNumberOfThreads) {
        this.taskQueue = new ArrayBlockingQueue<>(maxNumberOfThreads);
        this.runnables = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            MyPoolThreadRunnable myPoolThreadRunnable = new MyPoolThreadRunnable(taskQueue);

            runnables.add(myPoolThreadRunnable);
        }

        for (MyPoolThreadRunnable poolThreadRunnable : runnables) {
            new Thread(poolThreadRunnable).start();
        }
    }


    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.add(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (MyPoolThreadRunnable poolThreadRunnable : runnables) {
            poolThreadRunnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (!this.taskQueue.isEmpty()) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
