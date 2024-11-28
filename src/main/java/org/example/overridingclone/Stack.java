package org.example.overridingclone;

import java.util.Arrays;
import java.util.EmptyStackException;

// In practice, a class implementing Cloneable is expected to provide a properly functioning public clone method.
// Immutable classes should never provide a clone method.
// In effect, the clone method functions as a constructor; you must ensure that it does no harm to the original object and that it properly
// establishes invariants on the clone.
// The Cloneable architecture is incompatible with normal use of final fields referring to mutable objects.
public class Stack implements Cloneable {
    private Object[] elements; // Arrays are the sole compelling use of the clone facility
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // The addition of using null on pop() is the real example here to prevent memory leaks.
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    // Ensure space for at least one more element, roughly doubling the capacity
    // each time the array needs to grow.
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    // Clone method for class with references to mutable state
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone(); // Calling clone recursively on the elements array
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // If your class isn't implementing Cloneable, you're better off copying objects with a...
    // 1. Copy constructor
    public Stack(Stack original) {
        this.elements = Arrays.copyOf(original.elements, original.elements.length);
        this.size = original.size;
    }

    // If your class isn't implementing Cloneable, you're better off copying objects with a...
    // 2. Copy static factory method
    public static Stack copyOf(Stack original) {
        return new Stack(original);
    }
}
