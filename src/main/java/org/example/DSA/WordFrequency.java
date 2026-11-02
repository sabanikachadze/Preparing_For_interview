package org.example.DSA;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFrequency {


    public static Map<String, Integer> wordFrequency(String text) {

        return Pattern.compile("[a-zA-Z]+")
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .map(word -> word.toLowerCase(Locale.ROOT))
                .collect(Collectors.toMap(
                        Function.identity(),
                        word -> 1,
                        Integer::sum,
                        TreeMap::new));
    }
}
