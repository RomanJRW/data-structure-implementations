package com.joshwindels;

import java.util.NoSuchElementException;

public class Stack<T> {

    private StackElement top;

    public void push(T value) {
        if (top == null) {
            top = new StackElement(value);
        } else {
            StackElement newElement = new StackElement(value);
            newElement.setNextElement(top);
            top = newElement;
        }
    }

    public T pop() {
        if (top == null) {
            throw new NoSuchElementException();
        } else {
            StackElement poppedElement = top;
            top = top.getNextElement();
            return poppedElement.getValue();
        }
    }

    private class StackElement {
        private T value;
        private StackElement nextElement;

        private StackElement(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public StackElement getNextElement() {
            return nextElement;
        }

        public void setNextElement(StackElement nextElement) {
            this.nextElement = nextElement;
        }

    }

}
