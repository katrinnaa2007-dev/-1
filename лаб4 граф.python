python
import heapq
from collections import defaultdict

class Graph:
    def __init__(self):
        self.edges = defaultdict(dict)
    
    def add_edge(self, u, v, weight):
        self.edges[u][v] = weight
        self.edges[v][u] = weight  # для неориентированного графа
    
    def dijkstra(self, start, end):
        distances = {node: float('infinity') for node in self.edges}
        distances[start] = 0
        previous = {node: None for node in self.edges}
        queue = [(0, start)]
        
        while queue:
            current_distance, current_node = heapq.heappop(queue)
            
            if current_distance > distances[current_node]:
                continue
                
            if current_node == end:
                break
                
            for neighbor, weight in self.edges[current_node].items():
                distance = current_distance + weight
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous[neighbor] = current_node
                    heapq.heappush(queue, (distance, neighbor))
        
        # Восстановление пути
        path = []
        current = end
        while current is not None:
            path.append(current)
            current = previous[current]
        path.reverse()
        
        return path, distances[end]
