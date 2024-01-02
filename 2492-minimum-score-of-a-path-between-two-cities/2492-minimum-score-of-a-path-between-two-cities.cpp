class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& road : roads) {
            graph[road[0]].push_back({road[1], road[2]});
            graph[road[1]].push_back({road[0], road[2]});
        }
        
        int res = -1;
        
        if (graph[1].size() <= 0) {
            return res;
        }
        
        set<int> visitedNodes;
        set<pair<int, int>> visitedEdges;
        queue<int> q;
        int minDist = INT_MAX;

        q.push(graph[1][0].first);
        visitedNodes.insert(graph[1][0].first);
        minDist = graph[1][0].second;
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            vector<pair<int, int>> nNodes = graph[node];
            for (auto& nNode : nNodes) {
                if (visitedEdges.find({node, nNode.first}) == visitedEdges.end() ||
                    visitedEdges.find({nNode.first, node}) == visitedEdges.end()) {
                    visitedEdges.insert({node, nNode.first});
                    visitedEdges.insert({nNode.first, node});
                    if (visitedNodes.find(nNode.first) == visitedNodes.end()) {
                        q.push(nNode.first);
                        visitedNodes.insert(nNode.first);
                    }
                    minDist = min(minDist, nNode.second);
                }
            }
        }
        
        if (minDist != INT_MAX) {
            res = minDist;
        }

        return res;
    }
};