#include "PriorityQueue.h"

#include <cmath>
#include <string>
#include <vector>

template <class E>
PriorityQueue<E>::PriorityQueue()
{
    items.push_back(new Item<std::string>());
}


template <class E>
PriorityQueue<E>::~PriorityQueue()
{
    for (auto elem : items) {
        delete elem;
    }
}

template <class E>
void PriorityQueue<E>::push(int priority, E value)
{
    Item<E> *item = new Item<E>();
    
    item->setPriority(priority);
    item->setData(value);
    
    items.push_back(item);
    
    bubbleUp(items.size() -1);
    
}

template <class E>
int PriorityQueue<E>::size()
{
    return items.size() -1;
}

template <class E>
bool PriorityQueue<E>::isEmpty()
{
    return size() == 0;
}

template <class E>
void PriorityQueue<E>::bubbleUp(int index)
{
    Item<E> *current = items[index];
    
    int i = (int) std::floor(index / 2);
    
    if(i >= 1) {
        
        if(current->getPriority() < items[i]->getPriority()) {
            swapItems(current, items[i]);
            bubbleUp(i);
        }
        
    }
}

template <class E>
void PriorityQueue<E>::bubbleDown(int current)
{
    // Calculate the left and right indices
    int leftIndex = current * 2;
    int rightIndex = current * 2 + 1;

    // If there is a left child, run recursive for the left child
    if(leftIndex < items.size()) {
        if(items[leftIndex]->getPriority() < items[current]->getPriority()) {
            swapItems(items[current], items[leftIndex]);
        }
        bubbleDown(leftIndex);
    }

    // If there is a right child, run recursive for the right child
    if(rightIndex < items.size()) {
        if(items[rightIndex]->getPriority() < items[current]->getPriority()) {
            swapItems(items[current], items[rightIndex]);
        }
        bubbleDown(rightIndex);
    }

}

template <class E>
void PriorityQueue<E>::swapItems(Item<E>* l, Item<E>* r)
{
    E value = l->getData();
    l->setData(r->getData());
    r->setData(value);
    
    int prio = l->getPriority();
    l->setPriority(r->getPriority());
    r->setPriority(prio);
}

template <class E>
E PriorityQueue<E>::peek()
{
    return items[1]->getData();
}

template <class E>
E PriorityQueue<E>::pop()
{
    E next = items[1]->getData();
    swapItems(items[1], items[items.size()-1]);
    items.pop_back();
    bubbleDown(1);

    return next;
}


template class PriorityQueue<std::string>;