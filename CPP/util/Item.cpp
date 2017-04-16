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

template class Item<std::string>;
