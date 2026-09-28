package com.noobdevs.examples;

public class SingletonExample {

    private static volatile String dbConnection;

    private SingletonExample() {}

    public static String getDBInstance() {
        if (dbConnection == null) {
            synchronized (SingletonExample.class) {
                if (dbConnection == null) {
                    dbConnection = "Connection";
                }
            }
        }

        return dbConnection;
    }
}