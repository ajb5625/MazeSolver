/**
 * MyStack.java
 *
 * Project 1, part 1. Stack use array.
 *
 */

public class MyStack<E> {
    public static final int DEFAULT_SIZE = 32;

    private E[] stack;
    private int count;

    /**
     * Creates an empty Stack with initial capacity of {@code DEFAULT_SIZE}.
     */
    public MyStack(){
        this.stack = (E[])new Object[DEFAULT_SIZE];
        this.count = 0;
    }

    /**
     * Creates an empty Stack with initial capacity.
     * @param initialCapacity the initial capacity.
     */
    public MyStack(int initialCapacity) {
        this.stack = (E[])new Object[initialCapacity];
        this.count = 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        int size = 0;
        if (isEmpty()) {
            return 0;
        }
        for (int i = stack.length - 1; i >= 0; i--) {
            if (stack[i] != null) {
                return i + 1;
            }
        }
        return size;
    }

    /**
     * Returns {@code true} if this stack contains no elements.
     *
     * @return {@code true} if this stack contains no elements
     */
    public boolean isEmpty() {
        if (stack[0] == null) {
            return true;
        }
        return false;
    }

    /* resize the underlying array holding the elements */
    private void resize(int capacity) {

        E[] arr = (E[]) new Object [capacity];
        for (int i = 0; i < count; i++) {
            arr[i] = stack[i];
        }
        stack = arr;
    }

    /**
     * Adds the element to this stack.
     * @param e the element to add
     */
    public void push(E e) {
        if (count == stack.length) {
            resize(stack.length * 2);
        }
        stack[count++] = e;
    }

    /**
     * Removes and returns the element most recently added to this stack.
     * @return the element most recently added, or {@code null} if
     * this stack is empty
     *
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E toR = stack[--count];
        stack[count] = null;
        if (count > 0 && count == stack.length / 4) {
            resize(stack.length / 2);
        }
        return toR;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack, or {@code null} if
     * this stack is empty
     */
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        else {
            return stack[count - 1];
        }
    }
    
}

