package com.codewithmosh;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if(first == null) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int inedexOf(int item) {
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
        return inedexOf(item) != -1;
    }

    public void removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
            size = 0;
            return;
        }

        var newFirst = first.next;
        first.next = null;
        first = newFirst;

        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var previous  = getPrevious(last);
        last = previous;
        last.next = null;

        size--;
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

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        var contents = first;

        while(contents != null) {
            array[index] = contents.value;
            contents = contents.next;
            index++;
        }
        return array;
    }

    public void reverse() {
        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromEnd(int k) {
        if(isEmpty()) {
            throw new IllegalStateException();
        }

        if(k > size || k == 0) {
            throw new IllegalArgumentException();
        }

        int position = size - k;
        var current = first;
        for(int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void printMiddle() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }

        var current = first;
        var index = first;

        while(current != last && current.next != last) {
            current = current.next.next;
            index = index.next;
        }

        if(current == last) {
            System.out.println(index.value);
        } else {
            System.out.println(index.value + ", " + index.next.value);
        }
    }

    public boolean hasLoop() {
        var fast = first;
        var slow = first;

        while(fast.next != last && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast.next == slow) {
                return true;
            }
        }
        return false;
    }
}