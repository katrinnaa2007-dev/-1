cpp
#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <limits>

class Graph {
private:
    std::unordered_map<std::string, 
        std::vector<std::pair<std::string, int>>> edges;

public:
    void addEdge(const std::string& u, const std::string& v, int weight) {
        edges[u].push_back({v, weight});
        edges[v].push_back({u, weight}); // для неориентированного графа
    }
    
    std::pair<std::vector<std::string>, int> dijkstra(
        const std::string& start, const std::string& end) {
        
        std::unordered_map<std::string, int> distances;
        std::unordered_map<std::string, std::string> previous;
        std::priority_queue<std::pair<int, std::string>, 
            std::vector<std::pair<int, std::string>>, 
            std::greater<std::pair<int, std::string>>> queue;
        
        for (const auto& node : edges) {
            distances[node.first] = std::numeric_limits<int>::max();
        }
        distances[start] = 0;
        queue.push({0, start});
        
        while (!queue.empty()) {
            auto [current_distance, current_node] = queue.top();
            queue.pop();
            
            if (current_distance > distances[current_node]) continue;
            if (current_node == end) break;
            
            for (const auto& [neighbor, weight] : edges[current_node]) {
                int distance = current_distance + weight;
                if (distance < distances[neighbor]) {
                    distances[neighbor] = distance;
                    previous[neighbor] = current_node;
                    queue.push({distance, neighbor});
                }
            }
        }
        
        // Восстановление пути
        std::vector<std::string> path;
        std::string current = end;
        while (!current.empty()) {
            path.push_back(current);
            current = previous[current];
        }
        std::reverse(path.begin(), path.end());
        
        return {path, distances[end]};
    }
};
