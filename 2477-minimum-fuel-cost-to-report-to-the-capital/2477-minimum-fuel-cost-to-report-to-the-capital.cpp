class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int n = roads.size() + 1;
        vector<vector<int>> graph(n);
        for (auto& road : roads) {
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        
        long long res = 0;
        vector<int> passengerCount(n, 0);

        set<int> visited;
        // Pair of node and a flag indicating if children are processed
        stack<pair<int, bool>> s;

        // Start with the capital city
        s.push({0, false});
        visited.insert(0);
        while (!s.empty()) {
            int node = s.top().first;
            bool isProcessed = s.top().second;
            s.pop();
            vector<int> nNodes = graph[node];
            
            // First time this node is being processed, push it back onto the stack to process after all children
            if (!isProcessed) {
                // 精髓
                s.push({node, true});
                for (auto& nNode : nNodes) {
                    if (visited.find(nNode) == visited.end()) {
                        s.push({nNode, false});
                        visited.insert(nNode);
                    }
                }
            }
            // All children of this node have been processed, calculate passengers and fuel cost
            else {
                // Include self
                int passengers = 1;
                for (auto& nNode : nNodes) {
                    // Sum up the passengers from children
                    passengers += passengerCount[nNode];
                }
                // Update the passenger count for the current node
                passengerCount[node] = passengers;
                // If it's not the capital city (which doesn't have a parent), calculate the fuel cost
                if (node != 0) {
                    res += ceil(static_cast<double>(passengers) / seats);
                }
            }
        }

        return res;
    }
};