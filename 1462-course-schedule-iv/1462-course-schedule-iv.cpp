class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<vector<int>> graph(numCourses);
        for (auto& p : prerequisites) {
            graph[p[0]].push_back(p[1]);
        }

        vector<bool> res;
        
        int cache[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                cache[i][j] = false;
            }
        }
        int visited[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = false;
        }

        queue<int> q;
        for (auto& query : queries) {
            for (int i = 0; i < numCourses; i++) {
                visited[i] = false;
            }
            q = {};
            q.push(query[0]);
            visited[query[0]] = true;
            bool isPre = false;
            while (!q.empty()) {
                int node = q.front();
                q.pop();
                if (cache[node][query[1]]) {
                    isPre = true;
                    break;
                }
                if (node == query[1]) {
                    isPre = true;
                    break;
                }
                vector<int> nNodes = graph[node];
                for (auto& nNode : nNodes) {
                    if (!visited[nNode]) {
                        q.push(nNode);
                        visited[nNode] = true;
                        cache[node][nNode] = true;
                    }
                }
            }
            res.push_back(isPre);
        }
        
        return res;
    }
};