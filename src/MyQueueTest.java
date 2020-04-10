import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Test cases for the {@code MyQueue} class.
 *
 * <p>CS251 Project 1</p>
 *
 * @author Fangqin Sun
 * @version July 1, 2019
 */

public class MyQueueTest {

    private static final int[] NUM1;

    static {
        NUM1 = new int[]{1, 2, 2, 5, -1, 0, 34, 999, 02, 4, 4, -38423, 3, +45, 5, -43, 876, 34, 23, 423, 42, 342, 3, 2, Integer.MAX_VALUE, Integer.MIN_VALUE};
    } //static


    @Test(timeout = 100)
    public void testQueue1() {
        String message = "testing enqueue() and size()";
        MyQueue<Integer> mq = new MyQueue<Integer>();
        LinkedList<Integer> tq = new LinkedList<Integer>();
        for (int i : NUM1) {
            mq.enqueue(i);
            tq.offer(i);
            assertEquals(message, tq.size(), mq.size());
        }
    }

    @Test(timeout = 100)
    public void testQueue2() {
        Random random = new Random();
        Integer randomInteger;
        String message = "testing enqueue() and peek()";
        MyQueue<Integer> mq = new MyQueue<Integer>();
        LinkedList<Integer> tq = new LinkedList<Integer>();
        for (int i = 0; i < 1000; i++) {
            Integer integer = new Integer(i);
            mq.enqueue(integer);
            tq.offer(integer);
            assertSame(message, mq.peek(), tq.peek());
            randomInteger = new Integer(random.nextInt());
            mq.enqueue(randomInteger);
            tq.offer(randomInteger);
            assertSame(message, tq.peek(), mq.peek());
        }
    }

    @Test(timeout = 100)
    public void testQueue3() {
        String message = "testing dequeue() and isEmpty()";
        MyQueue<Integer> mq = new MyQueue<Integer>();
        LinkedList<Integer> tq = new LinkedList<Integer>();
        for (int i : NUM1) {
            Integer integer = new Integer(i);
            mq.enqueue(integer);
            tq.offer(integer);
        }
        for (int i : NUM1) {
            assertEquals(message, tq.poll(), mq.dequeue());
        }
        assertEquals(message, tq.isEmpty(), mq.isEmpty());
    }

    @Test(timeout = 2000)
    public void testQueue4() {
        Random random = new Random();
        int randomInt;
        String message = "testing enqueue() and dequeue()";
        MyQueue<Integer> mq = new MyQueue<Integer>();
        LinkedList<Integer> tq = new LinkedList<Integer>();
        for (int i = 0; i < 8000; i++) {
            if (random.nextInt(10) > 5) {
                if(!tq.isEmpty()) {
                    assertEquals(message, tq.poll(), mq.dequeue());
                }else{
                    assertEquals(message,null,mq.dequeue());
                }
            } else {
                randomInt = random.nextInt();
                mq.enqueue(randomInt);
                tq.offer(randomInt);
                assertEquals(message, tq.peek(), mq.peek());
            }

            assertEquals(message, tq.size(), mq.size());
        }
        while (!tq.isEmpty()) {
            assertEquals(message, tq.poll(), mq.dequeue());
        }
        assertEquals(message,null,mq.dequeue());
        assertEquals(message,null,mq.peek());
        assertEquals(message, tq.isEmpty(), mq.isEmpty());
    }
}
