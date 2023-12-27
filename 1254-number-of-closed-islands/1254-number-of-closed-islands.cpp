class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        int res = 0;
        
        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        queue<pair<int, int>> q;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                bool isClosed = true;
                if (grid[i][j] == 0 && !visited[i][j]) {
                    q.push({i , j});
                    visited[i][j] = true;
                    while (!q.empty()) {
                        pair<int, int> node = q.front();
                        q.pop();
                        int x = node.first;
                        int y = node.second;
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            isClosed = false;
                        }
                        for (auto& dir : dirs) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if (grid[newX][newY] == 0 && !visited[newX][newY]) {
                                    q.push({newX, newY});
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                    }
                    if (isClosed) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
};