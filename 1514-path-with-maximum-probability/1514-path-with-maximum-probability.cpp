class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        vector<vector<pair<int, double>>> graph(n);
        for (int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back({edges[i][1], succProb[i]});
            graph[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }

        vector<double> probs(n, 0);
        priority_queue<pair<double, int>, vector<pair<double, int>>, less<pair<double, int>>> pq;
        pq.push({1, start_node});
        probs[start_node] = 1;
        
        while (!pq.empty()) {
            pair<double, int> node = pq.top();
            pq.pop();
            int u = node.second;
            double uProb = node.first;
            if (u == end_node) {
                return probs[u];
            }
            vector<pair<int, double>> nNodes = graph[u];
            for (auto& nNode : nNodes) {
                int v = nNode.first;
                double vProb = nNode.second;
                if (probs[u] * vProb > probs[v]) {
                    probs[v] = probs[u] * vProb;
                    pq.push({probs[v], v});
                }
            }
        }
        
        return 0;
    }
};