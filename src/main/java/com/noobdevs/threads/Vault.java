package com.noobdevs.threads;

public class Vault {

    private final String password;

    public Vault(String password) {
        this.password = password;
    }

    public boolean isCorrectPassword(String password) {
        if (password == null || this.password == null) return false;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password.equals(password);
    }
}
