package com.codewithmosh;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int size = 0;
    private int rear;
    private int front;

    public ArrayQueue(int size) {
        items = new int[size];
    }

    public void enqueue(int item) {
        if(items.length == size) {
            throw new IllegalStateException("Queue is FULL!");
        }
        items[rear] = item;
        rear = (rear + 1) % items.length; //calculeaza perioada, se foloseste de asta pentru a realiza un array circular
        size++;
    }

    public int dequeue() {
        if(rear == 0) {
            throw new IllegalStateException("Queue is EMPTY!");
        }
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    public int peek() {
        return items[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}