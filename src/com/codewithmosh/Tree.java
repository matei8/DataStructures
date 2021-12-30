package com.codewithmosh;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        private Node right;
        private Node left;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node= " + value;
        }
    }

    private Node root;
    private int size = 0;

    public void insert(int value) {
        var node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if(value < current.value) {
                if(current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if(current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
        size++;
    }

    public boolean find(int value) {
        var current = root;
        if(current.value == value) {
            return true;
        }

        while(current != null) {
            if(value < current.value) {
                current = current.left;
            } else if(value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + "; ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
       if(root == null) {
           return;
       }

       traverseInOrder(root.left);
       System.out.print(root.value + "; ");
       traverseInOrder(root.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if(root == null) {
            return;
        }

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.value + "; ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null) {
            return -1;
        }

        if(root.left == null && root.right == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // O(log n); applies to Binary SEARCH Tree
    public int min() {
        var current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public boolean equals(Tree tree) {
        if(tree == null) {
            return false;
        }
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) {
            return true;
        }

        if(first != null && second != null) {
            return (first.value == second.value) && equals(first.left, second.left) && equals(first.right, second.right);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarysearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarysearchTree(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.value < min || root.value > max) {
            return false;
        }

        return isBinarysearchTree(root.left, min, root.value - 1) && isBinarysearchTree(root.right, root.value + 1, max);
    }

    public ArrayList<Integer> printNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        printNodesAtDistance(root, distance, list);
        return list;
    }

    private void printNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        if(distance == 0) {
            list.add(root.value);
        }

        printNodesAtDistance(root.left, distance - 1, list);
        printNodesAtDistance(root.right, distance - 1, list);
    }

    public void levelOrderTraversal(int level) {
        for(int i = 0; i <= height(); i++) {
            for(var items : printNodesAtDistance(i)) {
                System.out.print(items + " ");
            }
        }
    }

    public int size() {
        return size;
    }

    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if(root == null) {
            return 0;
        }

        if(isLeaf(root)) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if(root.right == null) {
            return root.value;
        }

        return max(root.right);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if(root == null) {
            return false;
        } else if(root.value == value) {
            return true;
        }

        return contains(root.left, value) || contains(root.right, value);
    }

    public boolean areSiblings(int leftValue, int rightValue) {
        if(leftValue == rightValue) {
            throw new IllegalArgumentException();
        }

        return areSiblings(root, leftValue, rightValue);
    }

    private boolean areSiblings(Node root, int leftValue, int rightValue) {
        if(root == null) {
            throw new IllegalStateException();
        }

        if(root.left == null || root.right == null) {
            return false;
        }

        if((root.left.value == leftValue && root.right.value == rightValue) || (root.left.value == rightValue && root.right.value == leftValue)) {
            return true;
        }

        return areSiblings(root.left, leftValue, rightValue) || areSiblings(root.right, leftValue, rightValue);
    }

    public List<Integer> getAncestors(int value) {
        if(!contains(value)) {
            throw new IllegalArgumentException();
        }
        var ancestors = new ArrayList<Integer>();
        getAncestors(root, value, ancestors);
        return ancestors;
    }

    private boolean getAncestors(Node root, int value, List<Integer> ancestors) {
        if(root == null) {
            return false;
        }

        if(root.value == value) {
            return true;
        }

        if(getAncestors(root.left, value, ancestors) || getAncestors(root.right, value, ancestors)) {
            ancestors.add(root.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        if(root == null) {
            return true;
        }

        return height(root.left) - height(root.right) <= 1;
    }

    public boolean isPerfect() {
        return isPerfect(root);
    }

    private boolean isPerfect(Node root) {
        return size() == Math.pow(2, height() - 1) + 1;
    }
}