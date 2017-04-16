#include <iostream>
#include <string>

#include "util/PriorityQueue.h"



using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    PriorityQueue<std::string> queue;
    
    queue.push(10, "hello world");
    queue.push(1, "lol");
    queue.push(5, "hi");
    
    
    cout << "Size is: " << queue.size()  << endl;
    cout << "The value is : " << queue.peek() << endl;
    
    return 0;
}

