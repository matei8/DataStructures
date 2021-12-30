package com.codewithmosh;

public class LinkedListQueue {
    public class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    // O(1)
    public void enqueue (int item) {
        var node = new Node(item);

        if(isEmpty()) {
            first = last = node;
            return;
        }

        last.next = node;
        last = node;
        size++;
    }


    // O(1)
    public void dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is EMPTY!");
        }

        first = null;
        first = first.next;
        size--;
    }

    // O(1)
    public boolean isEmpty() {
        return first == null;
    }

    // O(1)
    public int peek() {
        return first.value;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while(current.next != null) {
            if(current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while(current != null) {
            if(current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
}
