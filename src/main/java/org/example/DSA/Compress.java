package org.example.DSA;

import java.util.Map;
import java.util.TreeMap;

public class Compress {

    public static String compress(String s) {
        Map<Character, Integer> Chars = new TreeMap<>();
        StringBuilder compressedChars = new StringBuilder();

        for (char chr : s.toCharArray()) {

            Chars.merge(chr, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> e : Chars.entrySet()) {
            compressedChars.append(e.getKey()).append(e.getValue());
        }
        return compressedChars.toString();
    }

}
