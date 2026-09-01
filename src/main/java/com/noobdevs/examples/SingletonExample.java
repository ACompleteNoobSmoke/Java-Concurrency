package com.noobdevs.examples;

public class SingletonExample {

    private static volatile Object dbConnection = null;

    private SingletonExample(){}

    public static Object getDbConnection() {
        if (dbConnection == null) {
            synchronized (SingletonExample.class) {
                if (dbConnection == null) {
                    dbConnection = new Object();
                }
            }
        }

        return dbConnection;
    }
}
