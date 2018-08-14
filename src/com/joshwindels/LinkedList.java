package com.joshwindels;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private ListNode head;

    public LinkedList() {
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
        T removedValue = head.getValue();
        head = currentHead.getNextNode();
        return removedValue;
    }

    public void addToEnd(T newValue) {
        ListNode newNode = new ListNode(newValue);
        ListNode currentNode = head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(newNode);
    }

    public T removeFromEnd() {
        T removedValue = null;
        if (head == null) {
            throw new NoSuchElementException();
        } else if (!head.hasNextNode()) {
            removedValue = head.getValue();
            head = null;
        } else {
            ListNode currentNode = head;
            while (currentNode.hasNextNode()) {
                if (!currentNode.getNextNode().hasNextNode()) {
                    removedValue = currentNode.getNextNode().getValue();
                    currentNode.setNextNode(null);
                } else {
                    currentNode = currentNode.getNextNode();
                }
            }
        }
        return removedValue;
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("List values: ");
        ListNode currentNode = head;
        while (currentNode != null) {
            listString.append(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        return listString.toString();
    }

    public class ListNode {

        T value;
        ListNode nextNode;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

        public boolean hasNextNode() {
            return getNextNode() != null;
        }

    }

}
