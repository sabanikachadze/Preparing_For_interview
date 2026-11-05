package org.example.DSA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Balancing {

    static boolean isBalanced(String s) {
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
