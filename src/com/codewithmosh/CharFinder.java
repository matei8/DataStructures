package com.codewithmosh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    private Set<Character> set = new HashSet<>(); //used for eliminating the extra chars
    private Map<Character, Integer> map = new HashMap<>(); //used for mapping the times a char appears in a string

    public char firstNonRepeatedChar(String str) {
        var chars = str.toCharArray();

        for(var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0; //if map contains the char initialize count with the value of the key, else set it to 0
            map.put(ch, count + 1);
        }

        for(var ch : chars) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public char firstRepeatedChar(String str) {
        var chars = str.toCharArray();

        for(var ch : chars) {
            if(!set.add(ch)) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }
}