class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& time : times) {
            graph[time[0]].push_back({time[1], time[2]});
        }
        
        vector<int> dist(n + 1, INT_MAX);
        dist[k] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, k});

        while (!pq.empty()) {
            pair<int, int> node = pq.top();
            int u = node.second;
            int uDist = node.first;
            pq.pop();

            if (uDist > dist[u]) {
                continue;
            }

            for (auto& neighbor : graph[u]) {
                int v = neighbor.first;
                int weight = neighbor.second;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.push({dist[v], v});
                }
            }
        }

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == INT_MAX) {
                return -1;
            }
            res = max(res, dist[i]);
        }
        
        return res;
    }
};