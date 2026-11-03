package org.example.DSA;

import java.util.Map;
import java.util.TreeMap;

public class Compress {

    public static String compress(String s) {

        if (s.isEmpty()){
            return "";
        }

        StringBuilder compressedChars = new StringBuilder();
        int amount = 0;
        char currentChar = s.charAt(0);

        for (char chr : s.toCharArray()) {

            if (currentChar != chr) {
                compressedChars.append(currentChar);
                compressedChars.append(amount);

                currentChar = chr;
                amount = 0;
            }

            amount++;
        }

        compressedChars.append(currentChar);
        compressedChars.append(amount);

        return compressedChars.toString();
    }

}
