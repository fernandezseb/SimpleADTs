#include "Item.h"

#include <string>

template <class E>
int Item<E>::getPriority()
{
    return priority;
}

template <class E>
void Item<E>::setPriority(int priority)
{
    this->priority = priority;
}

template <class E>
E Item<E>::getData()
{
    return data;
}

template <class E>
void Item<E>::setData(E data)
{
    this->data = data;
}

template <class E>
bool operator< (Item<E> const& l, Item<E> const& r)
{
    return l.getPriority() < r.getPriority();
}

template class Item<std::string>;