class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        
        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        queue<pair<int, int>> q;
        
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = 0;
                    q.push({i, j});
                    visited[i][j] = true;
                    while (!q.empty()) {
                        pair<int, int> node = q.front();
                        q.pop();
                        int x = node.first;
                        int y = node.second;
                        size++;
                        for (auto& dir : dirs) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if (grid[newX][newY] == 1 && !visited[newX][newY]) {
                                    q.push({newX, newY});
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                    }
                    res = max(res, size);
                }
            }
        }
        
        return res;
    }
};