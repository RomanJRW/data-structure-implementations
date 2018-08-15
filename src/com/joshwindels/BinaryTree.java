package com.joshwindels;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

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

    public void removeValue(int value) {
        removeValueRecursive(rootNode, value);
    }

    private TreeNode removeValueRecursive(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value < currentNode.getValue()) {
            currentNode.setLeftChild(removeValueRecursive(currentNode.getLeftChild(), value));
            return currentNode;
        } else if (value > currentNode.getValue()) {
            currentNode.setRightChild(removeValueRecursive(currentNode.getRightChild(), value));
            return currentNode;
        } else {
            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                return null;
            } else if (currentNode.getLeftChild() == null) {
                return currentNode.getRightChild();
            } else if (currentNode.getRightChild() == null) {
                return currentNode.getLeftChild();
            } else {
                int lowestValue = findLowestValue(currentNode.getRightChild());
                currentNode.setValue(lowestValue);
                currentNode.setRightChild(removeValueRecursive(currentNode.getRightChild(), lowestValue));
                return currentNode;
            }
        }
    }

    private int findLowestValue(TreeNode treeNode) {
        if (treeNode.getLeftChild() == null) {
            return treeNode.getValue();
        } else {
            return findLowestValue(treeNode.getRightChild());
        }
    }

    public void printInOrderDFSTraveral() {
        inOrderDFSTraversal(rootNode);
    }

    private void inOrderDFSTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderDFSTraversal(treeNode.getLeftChild());
            System.out.print(" " + treeNode.getValue());
            inOrderDFSTraversal(treeNode.getRightChild());
        }
    }

    public void printPreOrderDFSTraveral() {
        preOrderDFSTraversal(rootNode);
    }

    private void preOrderDFSTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(" " + treeNode.getValue());
            preOrderDFSTraversal(treeNode.getLeftChild());
            preOrderDFSTraversal(treeNode.getRightChild());
        }
    }

    public void printPostOrderDFSTraveral() {
        preOrderDFSTraversal(rootNode);
    }

    private void postOrderDFSTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            postOrderDFSTraversal(treeNode.getLeftChild());
            postOrderDFSTraversal(treeNode.getRightChild());
            System.out.print(" " + treeNode.getValue());
        }
    }

    public void printBFSTraveral() {
        if (rootNode == null) {
            return;
        }
        Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
        treeNodes.add(rootNode);

        while (!treeNodes.isEmpty()) {

            TreeNode treeNode = treeNodes.remove();

            System.out.print(" " + treeNode.value);

            if (treeNode.getLeftChild() != null) {
                treeNodes.add(treeNode.getLeftChild());
            }

            if (treeNode.getRightChild()!= null) {
                treeNodes.add(treeNode.getRightChild());
            }
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

        public void setValue(int value) {
            this.value = value;
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
