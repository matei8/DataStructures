package com.codewithmosh;

public class MaxHeap {
    public static void heapify(int[] array) {
        if(array.length == 0) {
            throw new IllegalStateException();
        }

        for(int index = 0; index < array.length; index++) {
            heapify(array, index);
        }
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if(leftIndex < array.length && array[largerIndex] < array[leftIndex]) {
            largerIndex = leftIndex;
        }

        var rightIndex = index * 2 + 2;
        if(rightIndex < array.length && array[largerIndex] < array[rightIndex]) {
            largerIndex = rightIndex;
        }

        if(largerIndex == index) {
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        var aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }
}
