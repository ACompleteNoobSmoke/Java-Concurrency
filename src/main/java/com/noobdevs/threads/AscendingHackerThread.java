package com.noobdevs.threads;

public class AscendingHackerThread extends HackerThread {

    private int maxGuesses;

    public AscendingHackerThread(int maxGuesses, Vault vault) {
        this.maxGuesses = maxGuesses;
        this(vault);
    }

    private AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = 0; guess < maxGuesses; guess++) {

        }
    }
}
