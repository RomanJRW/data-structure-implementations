package com.joshwindels;

import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {

    private ListNode head;

    public DoubleLinkedList() {
        head = null;
    }

    public void addToFront(T newValue) {
        ListNode newNode = new ListNode(newValue);
        newNode.setNextNode(head);
        head = newNode;
    }

    public T removeFromFront() {
        ListNode currentHead = head;
        if (currentHead == null) {
            throw new NoSuchElementException();
        }
        head = currentHead.getNextNode();
        return currentHead.getValue();
    }

    public void addToBack(T newValue) {
        ListNode newNode = new ListNode(newValue);
        ListNode currentNode = head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(newNode);
    }

    public T removeFromBack() {
        ListNode currentNode = head;
        if (currentNode == null) {
            throw new NoSuchElementException();
        }
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.getPreviousNode().setNextNode(null);
        return currentNode.getValue();
    }

    public class ListNode {

        T value;
        ListNode previousNode;
        ListNode nextNode;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public ListNode getPreviousNode() {
            return previousNode;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

    }

}
