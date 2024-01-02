class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        map<string, vector<pair<string, double>>> graph;
        for (int i = 0; i < equations.size(); i++) {
            graph[equations[i][0]].push_back({equations[i][1], values[i]});
            graph[equations[i][1]].push_back({equations[i][0], 1.0 / values[i]});
        }
        
        vector<double> answers(queries.size(), -1);

        for (int i = 0; i < queries.size(); i++) {
            vector<string> query = queries[i];
            if (graph.find(query[0]) == graph.end() || graph.find(query[1]) == graph.end()) {
                continue;
            }
            set<string> visited;
            stack<pair<string, double>> s;
            s.push({query[0], 1});
            visited.insert(query[0]);
            while (!s.empty()) {
                pair<string, double> node = s.top();
                s.pop();
                if (node.first == query[1]) {
                    answers[i] = node.second;
                    break;
                }
                vector<pair<string, double>> nNodes = graph[node.first];
                for (auto& nNode : nNodes) {
                    if (visited.find(nNode.first) == visited.end()) {
                        s.push({nNode.first, node.second * nNode.second});
                        visited.insert(nNode.first);
                    }
                }
            }
        }
        
        return answers;
    }
};