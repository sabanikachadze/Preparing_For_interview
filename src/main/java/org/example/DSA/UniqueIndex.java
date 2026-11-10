package org.example.DSA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueIndex {

    public static int firstUniqueIndex(String s) {

        Map<Character, Integer> frequency = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequency.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    record Student(String name, int score) {
    }

    static List<String> top3Names(List<Student> students) {

        return students.stream()
                .sorted(Comparator.comparing(Student::score)
                        .reversed()
                        .thenComparing(Student::name))
                .limit(3)
                .map(Student::name)
                .toList();
    }


}
