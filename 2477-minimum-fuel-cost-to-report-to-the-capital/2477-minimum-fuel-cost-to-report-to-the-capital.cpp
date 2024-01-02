class Solution {
public:
    long long minimumFuelCost(std::vector<std::vector<int>>& roads, int seats) {
        int n = roads.size() + 1;
        std::vector<std::vector<int>> graph(n);
        for (auto& road : roads) {
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        
        long long res = 0;
        std::vector<int> passengerCount(n, 0);
        std::set<int> visited;
        std::stack<std::pair<int, bool>> s; // Pair of node and a flag indicating if children are processed

        s.push({0, false}); // Start with the capital city
        visited.insert(0);
        while (!s.empty()) {
            int node = s.top().first;
            bool childrenProcessed = s.top().second;
            s.pop();
            
            if (!childrenProcessed) {
                // First time this node is being processed, push it back onto the stack to process after all children
                s.push({node, true});
                for (auto& child : graph[node]) {
                    if (visited.find(child) == visited.end()) {
                        s.push({child, false});
                        visited.insert(child);
                    }
                }
            } else {
                // All children of this node have been processed, calculate passengers and fuel cost
                int passengers = 1; // Include self
                for (auto& child : graph[node]) {
                    passengers += passengerCount[child]; // Sum up the passengers from children
                }
                passengerCount[node] = passengers; // Update the passenger count for the current node
                
                // If it's not the capital city (which doesn't have a parent), calculate the fuel cost
                if (node != 0) {
                    res += std::ceil(static_cast<double>(passengers) / seats);
                }
            }
        }

        return res;
    }
};