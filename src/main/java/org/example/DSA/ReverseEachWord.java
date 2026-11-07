package org.example.DSA;

public class ReverseEachWord {

    public static void main(String[] args){

        System.out.println(reverseEachWord("I was on top of the mountain and that's the life experience you must have"));

    }

    static String reverseEachWord(String s) {
        if (s == null){
            throw new IllegalArgumentException("Cannot operate on null string");
        }
        if (s.isBlank()) {
            return s;
        }

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++){
            String[] chars = words[i].split("");
            int length = chars.length - 1;

            for (int j = 0; j <= length / 2; j++){

                String holder = chars[j];
                chars[j] = chars[length - j];
                chars[length - j] =  holder;
            }
            words[i] = String.join("", chars);
        }

        return String.join(" ", words);
    }


}
