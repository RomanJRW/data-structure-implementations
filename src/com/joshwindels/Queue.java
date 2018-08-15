package com.joshwindels;

import java.util.NoSuchElementException;

public class Queue<T> {

    private QueueElement front;

    public void enqueue(T value) {
        QueueElement currentElement = front;
        if (currentElement == null) {
            front = new QueueElement(value);
        } else {
            while (currentElement != null) {
                if (currentElement.getNextElement() == null) {
                    currentElement.setNextElement(new QueueElement(value));
                    break;
                }
                currentElement = currentElement.getNextElement();
            }
        }
    }

    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException();
        } else {
            QueueElement dequeuedElement = front;
            front = front.getNextElement();
            return dequeuedElement.getValue();
        }
    }


    private class QueueElement {

        private T value;
        QueueElement nextElement;

        public QueueElement(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public QueueElement getNextElement() {
            return nextElement;
        }

        public void setNextElement(QueueElement nextElement) {
            this.nextElement = nextElement;
        }

    }

}
