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

        // current is eerst het element dat we beschouwen
        Item<E> current = items.get(index);
        int i = (int) Math.floor(index / 2);

        while (i > 0) {
            // check if it fits in the array
            if (i <  1) {
                break;
            }

            // Vergelijken met de parent
            if(prio < items.get(i).getPriority()) {
                // verwisselen met de parent
                exchangeData(current, items.get(i));
            }

            current = items.get(i);
            i = (int) Math.floor(i / 2);
        }
    }

    private void bubbleDown(int current) {


            int leftIndex = current*2;
            int rightIndex = current*2 + 1;

            int leftprio = leftIndex  < items.size() ? items.get(leftIndex).getPriority() : Integer.MAX_VALUE;
            int rightprio = rightIndex < items.size() ? items.get(rightIndex).getPriority() : Integer.MAX_VALUE;

            if(leftprio < items.get(current).getPriority()) {
                exchangeData(items.get(current), items.get(leftIndex));
            }

            if(rightprio < items.get(current).getPriority()) {
                exchangeData(items.get(current), items.get(rightIndex));
            }

            if(leftIndex < items.size()) {
                bubbleDown(leftIndex);
            }

            if(rightIndex < items.size()) {
                bubbleDown(rightIndex);
            }

    }


    private void exchangeData(Item<E> l, Item<E> r) {
        System.out.println("Exchanging " + l.getPriority() + " with " + r.getPriority());
        E value = l.getData();
        l.setData(r.getData());
        r.setData(value);
    }
}
