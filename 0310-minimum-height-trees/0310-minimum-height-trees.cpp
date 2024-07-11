class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if (n == 1) {
            return {0};
        }
        vector<int> degrees(n, 0);
        vector<vector<int>> adj(n);
        for (int i = 0; i < edges.size(); i ++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (degrees[i] == 1) {
                q.push(i);
            }
        }
        int numNodes = n;
        while (numNodes > 2) {
            int size = q.size();
            numNodes -= size;
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                degrees[node]--;
                for (auto newNode : adj[node]) {
                    degrees[newNode]--;
                    if (degrees[newNode] == 1) {
                        q.push(newNode);
                    }
                }
            }
        }
        vector<int> result;
        while (!q.empty()) {
            result.push_back(q.front());
            q.pop();
        }
        return result;
    }
};