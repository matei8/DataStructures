package com.codewithmosh;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringExpression {
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrckets = Arrays.asList(')', '>', ']', '}');

    public boolean isBallanced(String input) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }

            if(stack.isEmpty()) {
                return false;
            }
            if (isRightBracket(ch)) {
                var top = stack.pop();
                if(!match(top, ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrckets.contains(ch);
    }

    private boolean match(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrckets.indexOf(right);
    }
}