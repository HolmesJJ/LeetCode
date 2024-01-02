class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        vector<vector<int>> redGraph(n);
        for (auto& edge : redEdges) {
            redGraph[edge[0]].push_back(edge[1]);
        }

        vector<vector<int>> blueGraph(n);
        for (auto& edge : blueEdges) {
            blueGraph[edge[0]].push_back(edge[1]);
        }
        
        set<pair<int, char>> visited;
        queue<int> q;
        vector<int> answer(n, -1);
        answer[0] = 0;

        if (redGraph[0].size() > 0) {
            q.push(0);
            visited.insert({0, 'B'});
            bool isRed = true;
            char color = 'R';
            int dist = 1;
            while (!q.empty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int node = q.front();
                    q.pop();
                    vector<int> nNodes;
                    if (isRed) {
                        nNodes = redGraph[node];
                    } else {
                        nNodes = blueGraph[node];
                    }
                    for (auto& nNode : nNodes) {
                        if (visited.find({nNode, color}) == visited.end()) {
                            q.push(nNode);
                            visited.insert({nNode, color});
                            if (answer[nNode] != -1) {
                                answer[nNode] = min(dist, answer[nNode]);
                            } else {
                                answer[nNode] = dist;
                            }
                        }
                    }
                }
                isRed = !isRed;
                color = color == 'B' ? 'R' : 'B';
                dist++;
            }
        }

        if (blueGraph[0].size() > 0) {
            q = {};
            visited.clear();
            q.push(0);
            visited.insert({0, 'R'});
            bool isRed = false;
            char color = 'R';
            int dist = 1;
            while (!q.empty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int node = q.front();
                    q.pop();
                    vector<int> nNodes;
                    if (isRed) {
                        nNodes = redGraph[node];
                    } else {
                        nNodes = blueGraph[node];
                    }
                    for (auto& nNode : nNodes) {
                        if (visited.find({nNode, color}) == visited.end()) {
                            q.push(nNode);
                            visited.insert({nNode, color});
                            if (answer[nNode] != -1) {
                                answer[nNode] = min(dist, answer[nNode]);
                            } else {
                                answer[nNode] = dist;
                            }
                        }
                    }
                }
                isRed = !isRed;
                color = color == 'B' ? 'R' : 'B';
                dist++;
            }
        }

        return answer;
    }
};