package org.example.casual;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MinStack {

    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> maxs = new ArrayDeque<>();

    public void push(int value) {
        if (values.isEmpty()) {
            values.push(value);
            maxs.push(value);
        } else {
            int max = maxs.peek();
            values.push(value);
            maxs.push(Math.max(max, value));
        }
    }

    public int pop() {

        try {
            maxs.pop();
            return values.pop();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("empty stack", e);
        }
    }

    public int max() {
       if (maxs.peek() == null){
            throw new IllegalStateException("empty stack");
       }

       return maxs.peek();
    }
}