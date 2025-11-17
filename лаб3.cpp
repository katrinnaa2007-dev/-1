1. Бинарная/биномиальная куча
cpp
#include <iostream>
#include <vector>
using namespace std;

class MinHeap {
    vector<int> heap;
    void heapifyUp(int index) {
        while (index && heap[index] < heap[(index-1)/2]) {
            swap(heap[index], heap[(index-1)/2]);
            index = (index-1)/2;
        }
    }
public:
    void insert(int key) {
        heap.push_back(key);
        heapifyUp(heap.size()-1);
    }
    // ... другие методы
};

2. Куча Фибоначчи

cpp
template<class T>
class FibonacciHeap {
    struct Node {
        T key;
        Node* parent;
        Node* child;
        Node* left;
        Node* right;
    };
    // ... реализация методов
};

3. Хеш-таблицы
cpp
#include <unordered_map>
using namespace std;

// Использование STL
unordered_map<string, int> hashMap;
hashMap["key"] = 10;
