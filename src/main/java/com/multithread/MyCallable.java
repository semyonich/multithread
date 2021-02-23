package com.multithread;

import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    private final List<Integer> intList;

    public MyCallable(List<Integer> intList) {
        this.intList = intList;
    }

    @Override
    public Long call() throws Exception {
        return intList.stream()
                .mapToLong(i -> i)
                .reduce(0, Long::sum);
    }
}
