package com.multithread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Long> {
    private static final int THRESHOLD = 20;
    private List<Integer> intList;

    public ForkJoinSum(List<Integer> intList) {
        this.intList = intList;
    }

    @Override
    public Long compute() {
        if (intList.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToLong(ForkJoinTask::join)
                    .reduce(0, Long::sum);
        } else {
            return processing(intList);
        }
    }

    private Collection<ForkJoinSum> createSubtasks() {
        List<ForkJoinSum> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ForkJoinSum(intList.subList(0, intList.size() / 2)));
        dividedTasks.add(new ForkJoinSum(intList.subList(intList.size() / 2, intList.size())));
        return dividedTasks;
    }

    private Long processing(List<Integer> list) {
        return list.stream()
                .mapToLong(i -> i)
                .reduce(0, Long::sum);
    }
}
