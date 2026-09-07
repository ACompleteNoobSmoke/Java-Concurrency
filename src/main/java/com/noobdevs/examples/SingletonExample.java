package com.noobdevs.examples;

public class SingletonExample {

    private static volatile Object dbInstance = null;

    private SingletonExample() {}

    public static Object getDbInstance() {
        if (dbInstance == null) {
            synchronized(SingletonExample.class) {
                if (dbInstance == null) {
                    dbInstance = new Object();
                }
            }
        }
        return dbInstance;
    }
}