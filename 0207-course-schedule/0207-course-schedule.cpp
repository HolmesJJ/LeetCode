class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, set<int>> neighbors;
        vector<int> indegree(numCourses, 0);
        for (auto &p : prerequisites) {
            neighbors[p[1]].insert(p[0]);
            indegree[p[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
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
                }
            }
        }
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
};