package ch10.theory.utilityClasses;

import java.util.Arrays;

public class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
        Arrays.fill(elements, -1);
    }

    public StackOfIntegers() {
        this(5);
    }

    public boolean empty() {
        return size == 0;
    }

    public int peek() {
        if (size != 0)
            return elements[size - 1];
        throw new RuntimeException("Stack empty");
    }

    public void push(int element) {
        if (size != elements.length) {
            elements[size++] = element;
        } else {
            throw new RuntimeException("Stack full");
        }
    }

    public int pop() {
        if (size > 0) {
            return elements[--size];
        }
        throw new RuntimeException("Stack empty");
    }

    public int getSize() {
        return size;
    }
}
