3. Практическая часть
3.1 Реализация на Python
Мультисписок (вложенный список)
python
# Создание и работа с вложенным списком
nested_list = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

# Добавление элемента
nested_list.append([10, 11, 12])

# Удаление элемента
nested_list.pop(1)

# Изменение элемента
nested_list[0][1] = 99

# Преобразование вложенного списка в плоский
def flatten_list(nested):
    flat_list = []
    for sublist in nested:
        if isinstance(sublist, list):
            flat_list.extend(flatten_list(sublist))
        else:
            flat_list.append(sublist)
    return flat_list

# Альтернативное решение
groups = [['Hong', 'Ryan'], ['Andry', 'Ross'], ['Mike', 'Smith']]
names = []
for group in groups:
    names.extend(group)
Очередь и Дек
python
from collections import deque

# Реализация очереди
class Queue:
    def __init__(self):
        self.items = deque()
    
    def enqueue(self, item):
        self.items.append(item)
    
    def dequeue(self):
        return self.items.popleft() if self.items else None
    
    def is_empty(self):
        return len(self.items) == 0
    
    def size(self):
        return len(self.items)

# Реализация дека
class Deque:
    def __init__(self):
        self.items = deque()
    
    def add_front(self, item):
        self.items.appendleft(item)
    
    def add_rear(self, item):
        self.items.append(item)
    
    def remove_front(self):
        return self.items.popleft() if self.items else None
    
    def remove_rear(self):
        return self.items.pop() if self.items else None
    
    def is_empty(self):
        return len(self.items) == 0

# Пример использования
q = Queue()
q.enqueue("task1")
q.enqueue("task2")
print(q.dequeue())  # task1

d = Deque()
d.add_front(1)
d.add_rear(2)
print(d.remove_front())  # 1
Приоритетная очередь
python
import heapq

class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0
    
    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1
    
    def pop(self):
        if self._queue:
            return heapq.heappop(self._queue)[-1]
        return None
    
    def is_empty(self):
        return len(self._queue) == 0

# Пример использования
pq = PriorityQueue()
pq.push("high priority task", 3)
pq.push("low priority task", 1)
pq.push("medium priority task", 2)

while not pq.is_empty():
    print(pq.pop())

