package com.noobdevs.threads;

public class ThreadExample8 {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable Running");
            while (!isStopRequested()) {
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable Stopped");
        }
    }

    static void main() {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "Based Thread");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("Stop requested");
    }
}
