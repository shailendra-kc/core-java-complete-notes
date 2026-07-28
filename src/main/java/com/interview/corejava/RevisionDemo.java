package com.interview.corejava;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class RevisionDemo {
    private RevisionDemo() {}

    public static void main(String[] args) throws Exception {
        demonstrateCollections();
        demonstrateStreams();
        demonstrateConcurrency();
    }

    private static void demonstrateCollections() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.put(1, "Java");
        cache.put(2, "Spring");
        cache.get(1);
        cache.put(3, "Kafka");
        System.out.println("LRU cache: " + cache);
    }

    private static void demonstrateStreams() {
        List<String> words = List.of("java", "spring", "java", "redis");
        Map<String, Long> frequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency: " + frequency);
    }

    private static void demonstrateConcurrency() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            CompletableFuture<String> java = CompletableFuture.supplyAsync(() -> "Core Java", executor);
            CompletableFuture<String> spring = CompletableFuture.supplyAsync(() -> "Spring Boot", executor);
            System.out.println(java.thenCombine(spring, (a, b) -> a + " + " + b).get());
        } finally {
            executor.shutdown();
        }
    }

    static final class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        LruCache(int capacity) {
            super(capacity, 0.75f, true);
            if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
