package com.multithread;

import org.apache.log4j.Logger;

public class ThreadClass extends Thread {
    private static final Logger logger = Logger.getLogger(ThreadClass.class);
    private final int iterationsNumber;
    private final Counter counter;

    public ThreadClass(int iterationsNumber, Counter counter) {
        this.iterationsNumber = iterationsNumber;
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Thread started....");
        while (counter.getCounter() < iterationsNumber) {
            logger.info(Thread.currentThread().getName() + " count=" + counter.getCounter());
            counter.increment();
        }
        logger.info("Thread finished!");
    }
}
