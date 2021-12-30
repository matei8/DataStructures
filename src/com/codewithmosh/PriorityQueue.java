package com.codewithmosh;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int size) {
        items = new int[size];
    }

    public void add(int item) {
        if(isFull()) {
            throw new IllegalStateException("Queue is FULL!");
        }

        var index = shiftToItem(item);
        items[index] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int shiftToItem(int item) {
        int i;
        for(i = count - 1; i >= 0; i--) {
            if(items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public void remove() {
        if(count == 0) {
            throw new IllegalStateException("Queue is EMPTY!");
        }

        items[count - 1] = 0;
        count--;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}