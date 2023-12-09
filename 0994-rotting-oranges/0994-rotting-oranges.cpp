class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<bool>> visited(m, vector<bool>(n, false));
        
        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 2) {
                    q.push({i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int res = 0;
        
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> node = q.front();
                q.pop();
                int x = node.first;
                int y = node.second;
                for (auto& dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (!visited[newX][newY] && grid[newX][newY] == 1) {
                            q.push({newX, newY});
                            grid[newX][newY] = 2;
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
            res++;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return res - 1 >= 0 ? res - 1 : 0;
    }
};