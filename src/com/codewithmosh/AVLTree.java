package com.codewithmosh;

public class AVLTree {
    private class AVLNode {
        private AVLNode right;
        private AVLNode left;
        private int value;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value = " + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if(root == null) {
            return new AVLNode(value);
        }

        if(value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if(isLeftHeavy(root)) {
            if(balanceFactor(root.left) < 0) {
                root.left = leftRotate(root.left);
            }
            return root = rightRotate(root);
        } else if(isRightHeavy(root)) {
            if(balanceFactor(root.right) > 0) {
                root.right = rightRotate(root.right);
            }
            return root = leftRotate(root);
        }
        return root;
    }

    private AVLNode leftRotate(AVLNode root) {
        var newRoot = root.right;

        newRoot.left = root.right;
        newRoot.left = root;

        // Reset the heights of the two interchanged nodes
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        var newRoot = root.left;

        newRoot.right = root.left;
        newRoot.right = root;

        // Reset the heights of the two interchanged nodes
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int balanceFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
}