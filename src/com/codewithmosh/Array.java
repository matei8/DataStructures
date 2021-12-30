package com.codewithmosh;

public class Array {
    private int[] items;
    private int count = 0;
    public int length;

    public Array (int arrayLength) {
        items = new int[arrayLength];
        length = arrayLength;
    }

    public void insert(int item) {
        //if the array is full, resize it
        if(items.length == count) {
            int[] newItems = new int[count * 2];
            for(int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count] = item;
        count++;
    }

    public void insertAt(int index, int item) {
        if(index < 0 || index > items.length) {
            throw new IllegalArgumentException();
        }
        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for(int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for(int i = 0; i < count; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int max = 0;
        for(int i = 0; i < count; i++) {
            if(items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public int get(int index) {
        return items[index];
    }

    public void intersect(Array array) {
        for(int i = 0; i < count; i++) {
           for(int j = 0; j < array.length; j++) {
               if(array.get(j) == items[i]) {
                   System.out.print(array.get(j) + " ");
               }
           }
        }
    }

    public void reverse() {
        int[] reverse = new int[items.length];
        for(int i = count - 1; i >= 0; i--) {
            reverse[i] = items[(count - 1) - i];
        }
        items = reverse;
    }
}