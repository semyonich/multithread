package com.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSum {
    private int numberOfThreads;
    private List<Integer> intList;

    public Long calculateSum() {
        int partitionListLength = intList.size() / numberOfThreads;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<MyCallable> callableTasks = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            callableTasks.add(new MyCallable(intList.subList(i * partitionListLength,
                    (i + 1) * partitionListLength)));
        }
        callableTasks.add(new MyCallable(intList.subList(intList.size()
                    - intList.size() % partitionListLength, intList.size())));
        List<Future<Long>> futures = null;
        try {
            futures = executor.invokeAll(callableTasks);
            executor.shutdown();
            Long sum = 0L;
            for (Future<Long> future : futures) {
                sum += future.get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Something got wrong", e);
        }
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }
}
