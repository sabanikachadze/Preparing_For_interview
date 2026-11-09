package org.example.DSA;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Winner {

    public static String winner(String[] votes) {
        Map<String, Integer> count = new HashMap<>();
        int halfSize = votes.length / 2;

        for (String s : votes) {
            count.merge(s, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() > halfSize) {
                return e.getKey();
            }
        }

        return "none";
    }

}
