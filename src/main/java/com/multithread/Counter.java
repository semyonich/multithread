package com.multithread;

public class Counter {
    private int counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }
}
