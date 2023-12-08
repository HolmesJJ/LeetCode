class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        unordered_map<int, set<int>> neighbors;
        set<pair<int, int>> edges;
        for (auto& connection : connections) {
            edges.insert({connection[0], connection[1]});
            neighbors[connection[0]].insert(connection[1]);
            neighbors[connection[1]].insert(connection[0]);
        }
        set<int> visited;
        int changes = 0;
        queue<int> q;
        q.push(0);
        visited.insert(0);
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (auto& neighbor : neighbors[node]) {
                if (visited.find(neighbor) == visited.end()) {
                    q.push(neighbor);
                    visited.insert(neighbor);
                    if (edges.find({neighbor, node}) == edges.end()) {
                        changes++;
                    }
                }
            }
        }
        return changes;
    }
};