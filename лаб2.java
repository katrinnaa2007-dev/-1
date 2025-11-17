3. Практическая часть
3.3 Реализация на Java
Двусвязный список
java
public class DoublyLinkedList<T> {
    private class Node {
        T data;
        Node prev;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public int size() {
        return size;
    }
}
Очередь и Дек
java
import java.util.*;

public class QueueDequeExample {
    // Пример использования Queue
    public static void queueExample() {
        Queue<String> queue = new LinkedList<>();
        queue.add("Task 1");
        queue.add("Task 2");
        queue.add("Task 3");
        
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }
    
    // Пример использования Deque
    public static void dequeExample() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        
        System.out.println("First: " + deque.getFirst());
        System.out.println("Last: " + deque.getLast());
        
        while (!deque.isEmpty()) {
            System.out.print(deque.removeFirst() + " ");
        }
        System.out.println();
    }
}
Приоритетная очередь
java
import java.util.*;

class Task implements Comparable<Task> {
    String name;
    int priority;
    
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // Максимальная куча
    }
    
    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        
        pq.add(new Task("Low priority task", 1));
        pq.add(new Task("High priority task", 3));
        pq.add(new Task("Medium priority task", 2));
        
        while (!pq.isEmpty()) {
            System.out.println("Processing: " + pq.poll());
        }
    }
}
