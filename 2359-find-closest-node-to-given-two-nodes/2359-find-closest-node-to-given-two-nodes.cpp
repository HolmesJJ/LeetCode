class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        
        vector<int> maxDists1(edges.size(), -1);
        vector<int> maxDists2(edges.size(), -1);
        
        set<int> visited;
        queue<int> q;
        if (node1 != -1) {
            q.push(node1);
            visited.insert(node1);
            maxDists1[node1] = 0;
            while (!q.empty()) {
                int node = q.front();
                q.pop();
                int nNode = edges[node];
                if (nNode != -1 && visited.find(nNode) == visited.end()) {
                    q.push(nNode);
                    visited.insert(nNode);
                    maxDists1[nNode] = maxDists1[node] + 1;
                }
            }
        }
        
        q = {};
        visited.clear();
        if (node2 != -1) {
            q.push(node2);
            visited.insert(node2);
            maxDists2[node2] = 0;
            while (!q.empty()) {
                int node = q.front();
                q.pop();
                int nNode = edges[node];
                if (nNode != -1 && visited.find(nNode) == visited.end()) {
                    q.push(nNode);
                    visited.insert(nNode);
                    maxDists2[nNode] = maxDists2[node] + 1;
                }
            }
        }
        
        int minMaxDist = INT_MAX;
        int res = -1;
        
        for (int i = 0; i < edges.size(); i++) {
            if (maxDists1[i] != -1 && maxDists2[i] != -1) {
                int maxDist = max(maxDists1[i], maxDists2[i]);
                if (minMaxDist > maxDist) {
                    minMaxDist = maxDist;
                    res = i;
                }
            }
        }
        
        return res;
    }
};