package com.multithread;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static List<Integer> getIntList(int length, int maxValue) {
        Random random = new Random();
        return IntStream.range(0, length)
                .boxed()
                .map(i -> random.nextInt(maxValue) + 1)
                .collect(Collectors.toList());
    }
}
