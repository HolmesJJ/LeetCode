class Solution {
public:
    int maxGold = 0;
    int m, n;
    vector<vector<int>> dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    void backtracking(vector<vector<int>>& grid, vector<vector<bool>>& visited, int x, int y, int currentGold) {
        maxGold = max(maxGold, currentGold);
        for (auto& dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] > 0 && !visited[newX][newY]) {
                visited[newX][newY] = true;
                backtracking(grid, visited, newX, newY, currentGold + grid[newX][newY]);
                visited[newX][newY] = false;
            }
        }
    }

    int getMaximumGold(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    visited[i][j] = true;
                    backtracking(grid, visited, i, j, grid[i][j]);
                    visited[i][j] = false;
                }
            }
        }
        return maxGold;
    }
};
