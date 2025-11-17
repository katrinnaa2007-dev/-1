1. Бинарная/биномиальная куча

java
public class BinaryHeap<T extends Comparable<T>> {
    private T[] elements;
    private int size;
    
    public void add(T element) {
        // Реализация вставки с просеиванием вверх
    }
    // ... другие методы
}
2. Куча Фибоначчи

java
public class FibonacciHeap {
    private Node min;
    private int size;
    
    private class Node {
        int key;
        Node parent, child, left, right;
        int degree;
        boolean mark;
    }
    
    public void insert(int key) {
        // Реализация вставки
    }
}
3. Хеш-таблицы

Java
java
import java.util.HashMap;

HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("key", 10);
