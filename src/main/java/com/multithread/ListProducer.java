package com.multithread;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListProducer {
    public static List<Long> getLongList(int length, int maxValue) {
        Random random = new Random();
        return IntStream.range(0, length)
                .boxed()
                .map(i -> (Long) ((long) (random.nextInt(maxValue) + 1)))
                .collect(Collectors.toList());
    }
}
