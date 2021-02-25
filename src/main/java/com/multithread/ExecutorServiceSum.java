package com.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceSum {
    private int numberOfThreads;
    private List<Long> longList;

    public Long calculateSum() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Callable<Long>> callableTasks = new ArrayList<>();
        List<List<Long>> subSets = ListUtils.partition(longList, numberOfThreads);
        for (List<Long> item : subSets) {
            callableTasks.add(new ListSumCalculator(item));
        }
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

    public void setLongList(List<Long> longList) {
        this.longList = longList;
    }
}
