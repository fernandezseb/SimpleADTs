package util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {

    class Item<E> {
        private int priority;
        private E data;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }


    private List<Item<E>> items;

    public PriorityQueue() {
        items = new ArrayList<>();
        items.add(new Item<E>());
    }

    public E peek() {
        checkIfEmpty();

        return items.get(1).getData();
    }

    public E pop() {
        checkIfEmpty();

        E next = items.get(1).getData();

        exchangeData(items.get(1), items.get(items.size()-1));
        items.remove(items.size()-1);
        bubbleDown(1);

        return next;
    }

    public void push(int priority, E value) {
        Item<E> item = new Item<>();
        item.setData(value);
        item.setPriority(priority);

        items.add(size(), item);

        bubbleUp(size()-1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return items.size() -1;
    }

    private void checkIfEmpty() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void bubbleUp(int index) {
        int prio = items.get(index).getPriority();

        // current the first element
        Item<E> current = items.get(index);
        // The index of the next item (parent) to check
        int i = (int) Math.floor(index / 2);

        // Make sure we don't go into the 0 element or negative elements
        while (i > 0) {

            // Compare the priority with the parent
            if(prio < items.get(i).getPriority()) {
                // Switch current value with the parent's
                exchangeData(current, items.get(i));
            }

            // Set the current to the parent
            current = items.get(i);
            // Set the new index of the supposed parent
            i = (int) Math.floor(i / 2);
        }
    }

    private void bubbleDown(int current) {


            /*
             * Calculate the left and right indices
             */
            int leftIndex = current*2;
            int rightIndex = current*2 + 1;

            /*
             * Get the left and right child priorities, set to maximum value in case of an empty child,
             * so that in won't try to switch later in the code
             */
            int leftprio = leftIndex  < items.size() ? items.get(leftIndex).getPriority() : Integer.MAX_VALUE;
            int rightprio = rightIndex < items.size() ? items.get(rightIndex).getPriority() : Integer.MAX_VALUE;

            // If the left child has higher priority, switch.
            if(leftprio < items.get(current).getPriority()) {
                exchangeData(items.get(current), items.get(leftIndex));
            }

            // If the right child has higher priority, switch.
            if(rightprio < items.get(current).getPriority()) {
                exchangeData(items.get(current), items.get(rightIndex));
            }

            // If there is a left child, run recursive for the left child
            if(leftIndex < items.size()) {
                bubbleDown(leftIndex);
            }

            // If there is a right child, run recursive for the right child
            if(rightIndex < items.size()) {
                bubbleDown(rightIndex);
            }

    }


    private void exchangeData(Item<E> l, Item<E> r) {
        E value = l.getData();
        l.setData(r.getData());
        r.setData(value);
    }
}
