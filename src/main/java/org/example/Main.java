package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static class HitCounter {
        private final Object lock = new Object();

        private int hits = 0;


         void hit() {
             synchronized (lock) { hits++; }
        }

         int total() {
             synchronized (lock) { return hits; }
        }
    }

    public static void main(String[] args) throws Exception {
        HitCounter counter = new HitCounter();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int t = 0; t < 4; t++) {
            pool.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter.hit();
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.total());
    }
}
