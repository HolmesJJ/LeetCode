class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
        }
        vector<vector<int>> iGraph(n);
        for (auto& edge : edges) {
            iGraph[edge[1]].push_back(edge[0]);
        }
        
        set<int> answers;
        set<int> visited;
        queue<int> q;
        
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 0) {
                q.push(i);
                visited.insert(i);
            }
        }

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            vector<int> nNodes = iGraph[node];
            if (nNodes.size() == 0) {
                answers.insert(node);
            }
            for (auto& nNode : nNodes) {
                if (visited.find(nNode) == visited.end()) {
                    q.push(nNode);
                    visited.insert(nNode);
                }
            }
        }

        vector<int> res;
        for (auto& answer : answers) {
            res.push_back(answer);
        }
        return res;
    }
};