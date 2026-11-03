package org.example;


import org.example.DSA.LastOccurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(LastOccurrence.lastOccurrence(new int[]{1, 2, 2, 2, 3}, 2));
    }
}
