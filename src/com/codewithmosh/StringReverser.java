package com.codewithmosh;

import java.util.Stack;

public class StringReverser {
    public String reverse(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuffer reversed = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
