package com.pg.java21;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java 21 introduced two notable changes to the virtual threads:
 *
 *  - Virtual threads now always support thread-local variables.
 *  - Virtual threads are created through the Thread.Builder APIs are also monitored through their lifetime and observable in the new thread dump
 */
public class VirtualThreadsDemo {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // Using virtual threads with Executors
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(VirtualThreadsDemo::task);
            }
        } // executor.close() is called implicitly, waits for all tasks

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + "ms");
        System.out.println("Total tasks completed: " + counter.get());
    }

    private static void task() {
        try {
            // Simulate some work
            Thread.sleep(Duration.ofMillis(100));
            counter.incrementAndGet();
            System.out.println("Task completed by " + Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Example of creating a single virtual thread
    private static void singleVirtualThreadExample() throws InterruptedException {
        Thread vThread = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from a virtual thread!");
        });
        vThread.join();
    }

    // Example of using Thread.Builder for virtual threads
    private static void threadBuilderExample() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("custom-vthread-", 0);
        Thread vThread = builder.start(() -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        });
        vThread.join();
    }
}
