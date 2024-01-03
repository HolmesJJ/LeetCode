class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        int res = 0;
        
        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;

        pq.push({grid[0][0], 0, 0});
        while (!pq.empty()) {
            vector<int> node = pq.top();
            int ue = node[0];
            int ux = node[1];
            int uy = node[2];
            pq.pop();
            res = max(res, ue);
            if (ux == m - 1 && uy == n - 1) {
                return res;
            }
            if (visited[ux][uy]) {
                continue;
            }
            visited[ux][uy] = true;
            for (auto& dir : dirs) {
                int vx = dir[0] + ux;
                int vy = dir[1] + uy;
                if (vx >= 0 && vx < m && vy >= 0 && vy < n) {
                    int ve = grid[vx][vy];
                    pq.push({grid[vx][vy], vx, vy});
                }
            }
        }

        return res;
    }
};