package com.codewithmosh;

public class TwoStacks {
    private int stack1;
    private int stack2;
    private int[] items;

    public TwoStacks(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("The capacity should be bigger than 0");
        }

        items = new int[capacity];
        stack1 = 0;
        stack2 = capacity;
    }

    public void push1(int item) {
        if(full1()) {
            throw new StackOverflowError();
        }
        items[++stack1] = item;
    }

    public void push2(int item) {
        if(full2()) {
            throw new StackOverflowError();
        }
        items[--stack2] = item;
    }

    public int pop1() {
        return items[stack1--];
    }

    public int pop2() {
        return items[stack2++];
    }

    public boolean full1() {
        return stack1 == stack2 - 1;
    }

    public boolean full2() {
        return stack2 == stack1 + 1;
    }

    public boolean isEmpty1() {
        return stack1 == 0;
    }

    public boolean isEmpty2() {
        return stack2 == items.length - 1;
    }
}
