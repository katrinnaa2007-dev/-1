1. Бинарная/биномиальная куча
python
import heapq

# Пример использования встроенной бинарной кучи
numbers = [8, 3, 5, 1, 6, 2, 4, 7]
heapq.heapify(numbers)
heapq.heappush(numbers, 0)
min_val = heapq.heappop(numbers)

2. Куча Фибоначчи
python
class FibonacciHeap:
    def __init__(self):
        self.min_node = None
        self.count = 0
    
    def insert(self, key):
        # Создание нового узла и добавление в кучу
        pass
    
    def extract_min(self):
        # Извлечение минимального элемента
        pass

3. Хеш-таблицы
python
class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
    
    def _hash(self, key):
        return hash(key) % self.size
    
    def put(self, key, value):
        index = self._hash(key)
        self.table[index] = value
