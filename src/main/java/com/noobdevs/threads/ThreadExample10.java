package com.noobdevs.threads;


import java.awt.print.Pageable;

import static java.lang.Thread.sleep;

public class ThreadExample10 {


    static void main() {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
}