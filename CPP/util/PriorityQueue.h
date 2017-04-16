
#ifndef PRIORITYQUEUE_H
#define PRIORITYQUEUE_H

#include <vector>

#include "Item.h"

template <class E>
class PriorityQueue {
public:
    PriorityQueue();
    virtual ~PriorityQueue();
    
    E peek();
    E pop();
    void push(int priority, E value);
    bool isEmpty();
    int size();
private:
    std::vector<Item<E>*> items;
    void bubbleUp(int index);
    void bubbleDown(int current);
    void swapItems(Item<E> *l, Item<E> *r);
};

#endif /* PRIORITYQUEUE_H */

