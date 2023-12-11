class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, set<int>> neighbors;
        vector<int> indegree(numCourses, 0);
        for (auto &p : prerequisites) {
            neighbors[p[1]].insert(p[0]);
            indegree[p[0]]++;
        }
        vector<int> res;
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
                res.push_back(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            set<int> nbs = neighbors[node];
            for (auto &nb : nbs) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    q.push(nb);
                    res.push_back(nb);
                }
            }
        }
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] != 0) {
                res.clear();
                return res;
            }
        }
        return res;
    }
};