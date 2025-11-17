3. Практическая часть
3.2 Реализация на C++
Двусвязный список (мультисписок)
cpp
#include <iostream>
using namespace std;

template<typename T>
struct Node {
    T data;
    Node* prev;
    Node* next;
    
    Node(T value) : data(value), prev(nullptr), next(nullptr) {}
};

template<typename T>
class DoublyLinkedList {
private:
    Node<T>* head;
    Node<T>* tail;
    int size;
    
public:
    DoublyLinkedList() : head(nullptr), tail(nullptr), size(0) {}
    
    void push_back(T value) {
        Node<T>* newNode = new Node<T>(value);
        if (!head) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    void push_front(T value) {
        Node<T>* newNode = new Node<T>(value);
        if (!head) {
            head = tail = newNode;
        } else {
            newNode->next = head;
            head->prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    void pop_back() {
        if (!tail) return;
        Node<T>* temp = tail;
        tail = tail->prev;
        if (tail) tail->next = nullptr;
        else head = nullptr;
        delete temp;
        size--;
    }
    
    void display() {
        Node<T>* current = head;
        while (current) {
            cout << current->data << " ";
            current = current->next;
        }
        cout << endl;
    }
    
    ~DoublyLinkedList() {
        while (head) {
            Node<T>* temp = head;
            head = head->next;
            delete temp;
        }
    }
};
Очередь и Дек
cpp
#include <queue>
#include <deque>
#include <iostream>
using namespace std;

// Пример использования std::queue
void queue_example() {
    queue<string> q;
    q.push("Task 1");
    q.push("Task 2");
    q.push("Task 3");
    
    while (!q.empty()) {
        cout << "Processing: " << q.front() << endl;
        q.pop();
    }
}

// Пример использования std::deque
void deque_example() {
    deque<int> dq;
    dq.push_back(1);
    dq.push_front(0);
    dq.push_back(2);
    
    cout << "Front: " << dq.front() << endl;
    cout << "Back: " << dq.back() << endl;
    
    while (!dq.empty()) {
        cout << dq.front() << " ";
        dq.pop_front();
    }
    cout << endl;
}
Приоритетная очередь
cpp
#include <queue>
#include <iostream>
#include <string>
using namespace std;

struct Task {
    string name;
    int priority;
    
    // Перегрузка оператора < для сравнения приоритетов
    bool operator<(const Task& other) const {
        return priority < other.priority; // Максимальная куча
    }
};

void priority_queue_example() {
    priority_queue<Task> pq;
    
    pq.push({"Low priority", 1});
    pq.push({"High priority", 3});
    pq.push({"Medium priority", 2});
    
    while (!pq.empty()) {
        Task task = pq.top();
        cout << "Processing: " << task.name 
             << " (Priority: " << task.priority << ")" << endl;
        pq.pop();
    }
}
