package util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class PriorityQueue<E extends Comparable<E>> {

    class Item<E> implements Comparable<Item<E>> {
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

        @Override
        public int compareTo(Item<E> o) {
            return Integer.compare(getPriority(), o.getPriority());
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

        swapItems(items.get(1), items.get(items.size()-1));
        items.remove(items.size()-1);
        bubbleDown(1);

        return next;
    }

    public void push(int priority, E value) {
        Item<E> item = new Item<>();
        item.setData(value);
        item.setPriority(priority);

        items.add(items.size(), item);

        bubbleUp(items.size()-1);

        printState();
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

        // current the first element
        Item<E> current = items.get(index);
        // The index of the next item (parent) to check
        int i = (int) Math.floor(index / 2);

        // Make sure we don't go into the 0 element or negative elements
        if (i >= 1) {

            // Compare the priority with the parent
            if(current.compareTo(items.get(i)) < 0) {
                // Switch current value with the parent's
                swapItems(current, items.get(i));
                bubbleUp(i);
            }
        }
    }

    private void bubbleDown(int current) {

            /*
             * Calculate the left and right indices
             */
            int leftIndex = current*2;
            int rightIndex = current*2 + 1;

            // If there is a left child, run recursive for the left child
            if(leftIndex < items.size()) {
                // If the left child has higher priority, switch.
                if(items.get(leftIndex).compareTo(items.get(current)) < 0) {
                    swapItems(items.get(current), items.get(leftIndex));
                }
                bubbleDown(leftIndex);
            }

            // If there is a right child, run recursive for the right child
            if(rightIndex < items.size()) {
                // If the right child has higher priority, switch.
                if(items.get(rightIndex).compareTo(items.get(current)) < 0) {
                    swapItems(items.get(current), items.get(rightIndex));
                }
                bubbleDown(rightIndex);
            }

    }


    private void swapItems(Item<E> l, Item<E> r) {
        System.out.println("Switching " + l.getData() + " with " + r.getData());
        E value = l.getData();
        l.setData(r.getData());
        r.setData(value);
        
        int prio = l.getPriority();
        l.setPriority(r.getPriority());
        r.setPriority(prio);
    }

    private void printState() {
        IntStream.range(0, items.size()).forEach(i -> System.out.printf("%d ", i));
        System.out.println();
        IntStream.range(0, items.size()).forEach(i -> System.out.printf("%d ", items.get(i).getPriority()));
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
    }
}
