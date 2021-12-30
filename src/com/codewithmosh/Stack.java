package com.codewithmosh;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    private int count = 0;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push(int item) {
        if (count == stack.length) {
            throw new StackOverflowError();
        } else {
            stack[count] = item;
            count++;
        }
    }

    public int peek() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        return stack[count - 1];
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}