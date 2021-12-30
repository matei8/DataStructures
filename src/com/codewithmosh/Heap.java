package com.codewithmosh;

public class Heap {
    private int[] items = new int[20];
    private int size = 0;

    // left child index: index * 2 + 1;
    // right child index: index * 2 + 2;
    // parent index: (index - 1) / 2;

    public void insert(int value) {
        if(size > items.length) {
            throw new IllegalStateException();
        }
        items[size++] = value;

        bubbleUp();
    }

    public void remove() {
        items[0] = items[size - 1];
        items[size - 1] = 0;
        size--;

        bubbleDown();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        var index = size - 1;
        while(index > 0 && items[index] > items[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private void bubbleDown() {
        if(size == 0) {
            throw new IllegalStateException();
        }

        var index = 0;
        while(items[index] < items[getRightChild(index)] || items[index] < items[getLeftChild(index)]) {
            if(items[getRightChild(index)] < items[getLeftChild(index)]) {
                swap(index, getLeftChild(index));
                index = getLeftChild(index);
            } else {
                swap(index, getRightChild(index));
                index = getRightChild(index);
            }
        }
    }

    public boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }

    private boolean isMaxHeap(int[] array, int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        if(array[index] >= array.length / 2) {
            return true;
        }

        if(array[index] >= array[leftChild] && array[index] >= array[rightChild]) {
            index++;
            return isMaxHeap(array, index);
        }

        return false;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private void swap(int index1, int index2) {
        var aux = items[index1];
        items[index1] = items[index2];
        items[index2] = aux;
    }

}