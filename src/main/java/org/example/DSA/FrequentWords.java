package org.example.DSA;

import java.util.*;

public class FrequentWords {

    public static List<String> topKFrequent(List<String> words, int k) {
        if (words == null) {
            throw new IllegalArgumentException();
        }

        if (k <= 0 || words.isEmpty()) {
            return new ArrayList<>();
        }

        Map<String, Integer> frequency = new HashMap<>();

        for (String s : words) {
            frequency.merge(s, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
                Comparator.<Map.Entry<String, Integer>, Integer>
                                comparing(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        return entries.stream()
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
