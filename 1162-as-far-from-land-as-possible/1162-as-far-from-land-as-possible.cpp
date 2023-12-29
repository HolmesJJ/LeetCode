class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        int dists[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dists[i][j] = 0;
            }
        }

        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.push({i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        if (q.size() == 0 || q.size() == m * n) {
            return -1;
        }

        while (!q.empty()) {
            pair<int, int> node = q.front();
            q.pop();
            int x = node.first;
            int y = node.second;
            for (auto& dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (!visited[newX][newY]) {
                        q.push({newX, newY});
                        visited[newX][newY] = true;
                        if (dists[newX][newY] == 0) {
                            dists[newX][newY] = dists[x][y] + 1;
                        }
                    }
                }
            }
        }

        int maxDist = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxDist = max(maxDist, dists[i][j]);
            }
        }
        return maxDist;
    }
};