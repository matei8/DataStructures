package com.codewithmosh;

public class MinStack {
    private Stack minStack;
    private Stack stack;

    public MinStack(int size) {
        minStack = new Stack(size);
        stack = new Stack(size);
    }

    public void push(int item) {
        stack.push(item);

        if(minStack.isEmpty()) {
            minStack.push(item);
        } else if(item < minStack.peek()) {
            minStack.push(item);
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        if(stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}