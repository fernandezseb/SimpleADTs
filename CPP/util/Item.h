
#ifndef ITEM_H
#define ITEM_H

template <class E>
class Item {
public:
    int getPriority();
    void setPriority(int priority);
    E getData();
    void setData(E data);
    
private:
    int priority;
    E data;
};


#endif /* ITEM_H */

