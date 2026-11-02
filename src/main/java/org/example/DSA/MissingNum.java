package org.example.DSA;

import java.util.Arrays;

public class MissingNum {

    public static int missingNumber(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        for (int x : nums) seen[x] = true;
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i]) return i;
        }
        return -1;
    }

}
