package com.multithread;

public class Application {
    private static final int ITERATIONS_NUMBER = 100;

    public static void main(String[] args) {
        Counter counter = new Counter();
        RunnableClass runnable = new RunnableClass(ITERATIONS_NUMBER, counter);
        ThreadClass thread = new ThreadClass(ITERATIONS_NUMBER, counter);
        Thread runnableThread = new Thread(runnable);
        thread.start();
        runnableThread.start();
    }
}
