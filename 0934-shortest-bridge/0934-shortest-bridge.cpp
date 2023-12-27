class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        int res = 0;

        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int dirs[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        queue<pair<int, int>> q1;
        queue<pair<int, int>> q2;
        
        bool flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q1.push({i, j});
                    q2.push({i, j});
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        
        while (!q1.empty()) {
            pair<int, int> node = q1.front();
            q1.pop();
            int x = node.first;
            int y = node.second;
            for (auto& dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (grid[newX][newY] == 1 && !visited[newX][newY]) {
                        q1.push({newX, newY});
                        q2.push({newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        while (!q2.empty()) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> node = q2.front();
                q2.pop();
                int x = node.first;
                int y = node.second;
                for (auto& dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (!visited[newX][newY]) {
                            if (grid[newX][newY] == 0) {
                                grid[newX][newY] = 1;
                                q2.push({newX, newY});
                                visited[newX][newY] = true;
                            } else {
                                return res;
                            }
                        }
                    }
                }
            }
            res++;
        }

        return res;
    }
};