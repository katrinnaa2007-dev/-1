java
import java.util.*;

class Graph {
    private Map<String, Map<String, Integer>> edges = new HashMap<>();
    
    public void addEdge(String u, String v, int weight) {
        edges.putIfAbsent(u, new HashMap<>());
        edges.putIfAbsent(v, new HashMap<>());
        edges.get(u).put(v, weight);
        edges.get(v).put(u, weight); // для неориентированного графа
    }
    
    public Pair<List<String>, Integer> dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Pair<Integer, String>> queue = 
            new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        
        for (String node : edges.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(new Pair<>(0, start));
        
        while (!queue.isEmpty()) {
            Pair<Integer, String> current = queue.poll();
            int currentDistance = current.getKey();
            String currentNode = current.getValue();
            
            if (currentDistance > distances.get(currentNode)) continue;
            if (currentNode.equals(end)) break;
            
            for (Map.Entry<String, Integer> neighbor : 
                 edges.get(currentNode).entrySet()) {
                int distance = currentDistance + neighbor.getValue();
                if (distance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), distance);
                    previous.put(neighbor.getKey(), currentNode);
                    queue.add(new Pair<>(distance, neighbor.getKey()));
                }
            }
        }
        
        // Восстановление пути
        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        
        return new Pair<>(path, distances.get(end));
    }
    
    // Вспомогательный класс Pair
    static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
