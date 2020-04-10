/**
 * MyQueue.java
 *
 * Project 1, part 1. Queue use link-list.
 *
 */

public class MyQueue<E> {

    private Node first;
    private Node last;
    private int count;

    class Node {
        private E e;
        private Node next;
    }

    /**
     * Creates an empty queue and initializes variables. 
     */
    public MyQueue(){
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number pf elements in the stack
     */
    public int size(){
        int c = 0;
        Node temp = first;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if this queue contains no elements; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Adds the element to this queue.
     * @param e the element to add
     */
    public void enqueue(E e) {
        Node olast = last;
        last = new Node();
        last.next = null;
        last.e = e;
        if (isEmpty()) {
            first = last;
        }
        else {
            olast.next = last;
        }
        count++;
    }

    /**
     * Removes and returns the element on this queue that was least recently added.
     * @return the element on this queue that was least recently added, or {@code null}
     * if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E e = first.e;
        first = first.next;
        count--;
        return e;
    }

    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue, or {@code null} if
     * this queue is empty
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return first.e;
    }

}
