package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PriorityQueueTest {

    private PriorityQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new PriorityQueue<>();
    }

    @Test
    public void newQueueIsEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void newQueueHasSizeZero() {
        assertEquals(0, queue.size());
    }

    @Test
    public void addGivesSize1() {
        queue.push(1, "hello");
        assertEquals(1, queue.size());
    }

    @Test
    public void addTwoGivesSize2() {
        queue.push(2,"hello");
        queue.push(3, "world");

        assertEquals(2, queue.size());
    }

    @Test
    public void addBubblesUp() {
        queue.push(3,"hello");
        queue.push(2, "world");

        assertEquals("world", queue.peek());
    }

    @Test
    public void addBubblesUp2() {
        queue.push(3,"hello");
        queue.push(2, "world");
        queue.push(5, "dag");
        queue.push(1, "wereld");
        queue.push(10, "hoi");

        assertEquals("wereld", queue.peek());
    }

    @Test
    public void popBubblesDown() {
        queue.push(3,"hello");
        queue.push(2, "world");
        queue.push(5, "dag");
        queue.push(1, "wereld");
        queue.push(10, "oom");

        queue.pop();
        assertEquals("world", queue.peek());
    }
}