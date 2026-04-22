package com.noobdevs.threads;

public class SwampIzzoThread extends Thread {


    public SwampIzzoThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Hello From " + this.getName());
    }

}
