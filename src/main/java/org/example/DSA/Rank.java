package org.example.DSA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Rank {

    record Result(String name, int score) {
    }

    static List<Result> rank(List<Result> results) {
        Comparator<Result> cmp = Comparator.comparingInt(Result::score).reversed()
                                   .thenComparing(Result::name);
        return results.stream()
                .sorted(cmp)
                .toList();
    }

}
