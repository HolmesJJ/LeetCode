class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        int res = INT_MAX;

        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        vector<vector<int>> visited(m, vector<int>(n, false));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        
        pq.push({0, 0, 0});
        while (!pq.empty()) {
            auto& node = pq.top();
            int ue = node[0];
            int ux = node[1];
            int uy = node[2];
            pq.pop();
            if (visited[ux][uy]) {
                continue;
            }
            visited[ux][uy] = true;
            if (ux == m - 1 && uy == n - 1) {
                return ue;
            }
            for (auto& dir : dirs) {
                int vx = dir[0] + ux;
                int vy = dir[1] + uy;
                if (vx >= 0 && vx < m && vy >= 0 && vy < n) {
                    if (!visited[vx][vy]) {
                        int ve = max(ue, abs(heights[vx][vy] - heights[ux][uy]));
                        pq.push({ve, vx, vy});
                    }
                }
            }
        }

        return res;
    }
};