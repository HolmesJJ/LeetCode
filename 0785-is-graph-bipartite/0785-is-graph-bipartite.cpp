class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        
        set<int> setA;
        set<int> setB;

        set<int> visitedNodes;
        set<pair<int, int>> visitedEdges;
        queue<int> q;
        
        for (int i = 0; i < n; i++) {
            if (visitedNodes.find(i) == visitedNodes.end()) {
                q.push(i);
                visitedNodes.insert(i);
                setA.insert(i);
                bool isA = false;
                while (!q.empty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int node = q.front();
                        q.pop();
                        vector<int> nNodes = graph[node];
                        for (auto& nNode : nNodes) {
                            if (visitedEdges.find({nNode, node}) == visitedEdges.end() ||
                                visitedEdges.find({node, nNode}) == visitedEdges.end()) {
                                visitedEdges.insert({nNode, node});
                                visitedEdges.insert({node, nNode});
                                // node is in setB, check if nNode is in setB as well
                                if (isA && setB.find(nNode) != setB.end()) {
                                    return false;
                                }
                                // node is in setA, check if nNode is in setA as well
                                if (!isA && setA.find(nNode) != setA.end()) {
                                    return false;
                                }
                                if (visitedNodes.find(nNode) == visitedNodes.end()) {
                                    q.push(nNode);
                                    visitedNodes.insert(nNode);
                                    if (isA) {
                                        setA.insert(nNode);
                                    } else {
                                        setB.insert(nNode);
                                    }
                                }
                            }
                        }
                    }
                    isA = !isA;
                }
            }
        }

        return true;
    }
};