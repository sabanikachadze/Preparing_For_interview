package org.example.DSA;

import java.util.*;

public class AllUniqueChars {

    public static boolean allUniqueChars(String s) {
        Set<Character> chars = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!chars.add(c)) {
                return false;
            }
        }

        return true;
    }

    public static OptionalInt majorityElement(int[] a) {
        int[] nums = new int[10];

        for (int n : a) {
            nums[n] += 1;
        }

        int highest = nums[0];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > highest) {
                highest = nums[i];
                index = i;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (index != i && nums[i] == highest) {
                return OptionalInt.empty();
            }
        }

        return OptionalInt.of(index + 1);
    }


    public class D13_Faulty {
        static void removeNegatives(List<Integer> values) {
            values.removeIf(integer -> integer < 0);
        }

        public static void main(String[] args) {
            List<Integer> data = new ArrayList<>(List.of(-1, -2, 3, -4, 5));
            removeNegatives(data);
            System.out.println(data);
        }
    }


}
