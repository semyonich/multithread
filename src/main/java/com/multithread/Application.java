package com.multithread;

public class Application {
    private static final int ITERATIONS_NUMBER = 100;
    private static final int COUNTER_START = 0;

    public static void main(String[] args) {
        Counter counter = new Counter(COUNTER_START);
        RunnableClass runnable = new RunnableClass(ITERATIONS_NUMBER, counter);
        ThreadClass thread = new ThreadClass(ITERATIONS_NUMBER, counter);
        thread.start();
        runnable.start();
    }
}
