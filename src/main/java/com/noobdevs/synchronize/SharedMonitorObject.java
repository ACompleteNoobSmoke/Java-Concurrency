package com.noobdevs.synchronize;

public class SharedMonitorObject {
    public static volatile Object databaseMonitor = null;


    private int counter = 0;

    public SharedMonitorObject() {
        this(new Object());
    }

    private SharedMonitorObject(Object databaseMonitor) {
        if (this.databaseMonitor != null) return;
        if (databaseMonitor == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        synchronized (this) {
            this.databaseMonitor = databaseMonitor;
        }
    }

    public void incCounter() {
        synchronized(this) {
            counter++;
        }
    }

    public synchronized int getCounter() {
        return counter;
    }
}
