package com.codewithmosh;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int size;

    private int hash(int key) { //basic hash function
        return key % entries.length;
    }

    private int index(int key, int i) { //get the next index in the array
        return (hash(key) + i) % entries.length;
    }

    private int getIndex(int key) { //find the index where to store de new value (using linear probing)
        int i = 0;
        while(i < entries.length) {
            int index = index(key, i++);
            var entry = entries[index];
            if(entry == null || entry.key == key) {
                return index;
            }
        }
        return -1;
    }

    private Entry getEntry(int key) {
        var index = getIndex(key);
        return index >= 0 ? entries[index] : null;
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }

        if(size > entries.length) {
            throw new IllegalStateException();
        }

        entries[getIndex(key)] = new Entry(key, value);
        size++;
    }

    public String get(int key) {
        var entry = getEntry(key);
        if(entry == null) {
            return null;
        }

        return entry.value;
    }

    public void remove(int key) {
        var index = getIndex(key);
        if(index == -1 || entries[index] == null) {
            return;
        }

        entries[index] = null;
        size--;
    }

    public int size() {
        return size;
    }
}