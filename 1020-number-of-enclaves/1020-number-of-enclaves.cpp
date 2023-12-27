class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        int area = 0;
        vector<int> areas;

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
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = 0;
                    bool isClosed = true;
                    q.push({i, j});
                    visited[i][j] = true;
                    while (!q.empty()) {
                        pair<int, int> node = q.front();
                        q.pop();
                        int x = node.first;
                        int y = node.second;
                        area++;
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            isClosed = false;
                        }
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
                    if (isClosed) {
                        areas.push_back(area);
                    }
                }
            }
        }

        int res = 0;
        for (auto& a : areas) {
            res += a;
        }
        return res;
    }
};