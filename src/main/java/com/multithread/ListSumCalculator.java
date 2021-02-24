package com.multithread;

import java.util.List;
import java.util.concurrent.Callable;

public class ListSumCalculator implements Callable<Long> {
    private final List<Long> longList;

    public ListSumCalculator(List<Long> longList) {
        this.longList = longList;
    }

    @Override
    public Long call() throws Exception {
        return longList.stream()
                .mapToLong(i -> i)
                .reduce(0, Long::sum);
    }
}
