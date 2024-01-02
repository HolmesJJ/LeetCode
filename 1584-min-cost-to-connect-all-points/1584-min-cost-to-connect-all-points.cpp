class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        vector<vector<pair<int, int>>> graph(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                graph[i].push_back({dist, j});
                graph[j].push_back({dist, i});
            }
        }
        
        int res = 0;
        vector<bool> visited(n, false);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        minHeap.push({0, 0});
        
        while (!minHeap.empty()) {
            auto [cost, i] = minHeap.top();
            minHeap.pop();
    
            if (visited[i]) {
                continue;
            }

            res += cost;
            visited[i] = true;

            for (auto& [neiCost, nei] : graph[i]) {
                if (!visited[nei]) {
                    minHeap.push({neiCost, nei});
                }
            }
        }

        return res;
    }
};