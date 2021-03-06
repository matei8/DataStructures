package com.codewithmosh;

import java.util.Stack;

public class StacksQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        moveStack1ToStack2();
        return stack2.pop();
    }

    public int peek() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}