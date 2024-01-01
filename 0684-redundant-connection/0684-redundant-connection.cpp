class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<vector<int>> graph(edges.size() + 1);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
            set<int> visited;
            queue<int> q;
            q.push(edge[0]);
            visited.insert(edge[0]);
            while (!q.empty()) {
                int count = 0;
                int node = q.front();
                q.pop();
                vector<int> nNodes = graph[node];
                for (auto& nNode : nNodes) {
                    if (visited.find(nNode) == visited.end()) {
                        q.push(nNode);
                        visited.insert(nNode);
                    } else {
                        count++;
                        if (count == 2) {
                            return edge;
                        }
                    }
                }
            }
        }
        return {};
    }
};