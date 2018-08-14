package com.joshwindels;

public class BinaryTree {

    private TreeNode rootNode;

    public BinaryTree() {
        rootNode =  null;
    }

    public void addValue(int value) {
        rootNode = addValueRecursive(rootNode, value);
    }

    private TreeNode addValueRecursive(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return new TreeNode(value);
        }
        if (value < currentNode.getValue()){
            currentNode.setLeftChild(addValueRecursive(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRightChild(addValueRecursive(currentNode.getRightChild(), value));
        }
        return currentNode;
    }

    public boolean containsValue(int value) {
        return containsValueRecursive(rootNode, value);
    }

    private boolean containsValueRecursive(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (value < currentNode.getValue()){
            return containsValueRecursive(currentNode.getLeftChild(), value);
        } else if (value > currentNode.getValue()) {
            return containsValueRecursive(currentNode.getRightChild(), value);
        } else {
            return true;
        }
    }

    private class TreeNode {

        int value;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

    }

}
