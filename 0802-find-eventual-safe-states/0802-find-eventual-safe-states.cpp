class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        set<int> eNodes;
        for (int i = 0; i < graph.size(); i++) {
            if (graph[i].size() == 0) {
                eNodes.insert(i);
            }
        }

        vector<vector<int>> iGraph(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            for (auto& nNode : graph[i]) {
                iGraph[nNode].push_back(i);
            }
        }

        vector<int> res;
        
        queue<int> q;
        set<int> visited;
        for (auto& eNode : eNodes) {
            q.push(eNode);
            visited.insert(eNode);
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            vector<int> pNodes = iGraph[node];
            for (auto& pNode : pNodes) {
                vector<int> nNodes = graph[pNode];
                bool isSafe = true;
                for (auto& nNode : nNodes) {
                    if (eNodes.find(nNode) == eNodes.end()) {
                        isSafe = false;
                    }
                }
                if (isSafe && visited.find(pNode) == visited.end()) {
                    q.push(pNode);
                    visited.insert(pNode);
                    eNodes.insert(pNode);
                }
            }
        }

        for (auto& eNode : eNodes) {
            res.push_back(eNode);
        }

        return res;
    }
};