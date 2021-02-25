package com.multithread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Long> {
    private static final int THRESHOLD = 20;
    private List<Long> longList;

    public ForkJoinSum(List<Long> longList) {
        this.longList = longList;
    }

    @Override
    public Long compute() {
        if (longList.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToLong(ForkJoinTask::join)
                    .reduce(0, Long::sum);
        }
        return process(longList);
    }

    private Collection<ForkJoinSum> createSubtasks() {
        List<ForkJoinSum> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ForkJoinSum(longList.subList(0, longList.size() / 2)));
        dividedTasks.add(new ForkJoinSum(longList.subList(longList.size() / 2, longList.size())));
        return dividedTasks;
    }

    private Long process(List<Long> list) {
        return list.stream()
                .mapToLong(i -> i)
                .reduce(0, Long::sum);
    }
}
