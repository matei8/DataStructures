package com.codewithmosh;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>(); //double ended queue = Deque, hence the name ArrayDeque
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is EMPTY!");
        }

        while(queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swap();

        return queue2.poll();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is EMPTY!");
        }

        return top;
    }

    private void swap() {
        var queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }
}

