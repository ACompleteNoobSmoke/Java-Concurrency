package com.noobdevs.exercises;

public class MyThreadPoolMain {

    private final int numberOfThreads;
    private final int maxNumberOfThreads;
    private final MyThreadPool myThreadPool;

    public MyThreadPoolMain(int numberOfThreads, int maxNumberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.maxNumberOfThreads = maxNumberOfThreads;
        this.myThreadPool = new MyThreadPool(numberOfThreads, maxNumberOfThreads);
    }

    static void main() {
        MyThreadPoolMain poolMain = new MyThreadPoolMain(3, 10);
        for (int i = 0; i < 20; i++) {
            int taskNo = i;
            try {
                poolMain.myThreadPool.execute(() -> {
                    String message = Thread.currentThread().getName() + " : Task " + taskNo;
                    System.out.println(message);
                    System.out.println();
                });
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
