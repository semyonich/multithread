package com.multithread;

import org.apache.log4j.Logger;

public class RunnableClass implements Runnable {
    private static final Logger logger = Logger.getLogger(RunnableClass.class);
    private final Counter counter;
    private final int iterationsNumber;
    private Thread thread;

    public RunnableClass(int iterationsNumber, Counter counter) {
        this.iterationsNumber = iterationsNumber;
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Runnable started....");
        while (counter.getCounter() < iterationsNumber) {
            logger.info(Thread.currentThread().getName() + " count=" + counter.getCounter());
            counter.increment();
        }
        logger.info("Runnable finished!");
    }
}
