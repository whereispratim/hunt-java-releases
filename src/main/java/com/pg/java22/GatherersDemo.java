package com.pg.java22;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream#gather is a preview API and may be removed in a future release
 */
public class GatherersDemo {

    public static void main(String[] args) {
        demonstrateFold(); //ordered, reduction-like transformation
        demonstrateMapConcurrent(); // using virtual threads, with a configured level of max concurrency
        demonstrateScan(); // Performs a prefix scan (incremental accumulation) using the provided functions
        demonstrateWindowFixed(); //Gathers elements into fixed-size, encounter-ordered groups (windows)
        demonstrateWindowSliding(); // window includes all elements of the previous window except for the least recent, and adds the next element
    }

    private static void demonstrateFold() {
        System.out.println("Usage of fold():");
        String result = Stream.of("Hello", " ", "Java 22", "!")
                .gather(Gatherers.fold(
                        StringBuilder::new,
                        (sb, str) -> sb.append(str)))
                .map(StringBuilder::toString)
                .findFirst()
                .orElse("");
        System.out.println(result);
        System.out.println();
    }

    private static void demonstrateMapConcurrent() {
        System.out.println("Usage of mapConcurrent():");
        List<Integer> result = Stream.generate(() -> ThreadLocalRandom.current().nextInt(100))
                .limit(10)
                .gather(Gatherers.mapConcurrent(4, i -> {
                    System.out.println("Processing " + i + " on thread: " + Thread.currentThread().getName());
                    return i * 2;
                }))
                .collect(Collectors.toList());
        System.out.println("Result: " + result); //[38, 90, 16, 42, 6, 20, 170, 42, 20, 4]
        System.out.println();
    }

    private static void demonstrateScan() {
        System.out.println("Usage of scan():");
        List<Integer> result = Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.scan(
                        () -> 0,
                        (acc, n) -> acc + n))
                .collect(Collectors.toList());
        System.out.println("Processing sum: " + result); // [1, 3, 6, 10, 15]
        System.out.println();
    }

    private static void demonstrateWindowFixed() {
        System.out.println("Usage of windowFixed():");
        List<List<Integer>> result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(Gatherers.windowFixed(4))
                .collect(Collectors.toList());
        System.out.println("Fixed windows of size 4: " + result); // [[1, 2, 3, 4], [5, 6, 7, 8], [9]]
        System.out.println();
    }

    private static void demonstrateWindowSliding() {
        System.out.println("Usage of windowSliding():");
        List<List<Integer>> result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .gather(Gatherers.windowSliding(3))
                .collect(Collectors.toList());
        System.out.println("Sliding windows of size 3: " + result); // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8]]
    }
}