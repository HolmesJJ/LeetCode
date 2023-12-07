class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int m = board.size();
        int n = board[0].size();
        
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        
        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        queue<pair<int, int>> q;
        queue<pair<int, int>> memo;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    bool isCaptured = true;
                    q.push({i, j});
                    if (i != 0 && i != m - 1 && j != 0 && j != n - 1) {
                        memo.push({i, j});
                    } else {
                        isCaptured = false;
                    }
                    visited[i][j] = true;
                    while (!q.empty()) {
                        pair<int, int> node = q.front();
                        q.pop();
                        int x = node.first;
                        int y = node.second;
                        for (auto& dir : dirs) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if (!visited[newX][newY] && board[newX][newY] == 'O') {
                                    if (newX != 0 && newX != m - 1 && newY != 0 && newY != n - 1) {
                                        q.push({newX, newY});
                                        if (isCaptured) {
                                            memo.push({newX, newY});
                                        }
                                        visited[newX][newY] = true;
                                    } else {
                                        isCaptured = false;
                                        memo = {};
                                    }
                                }
                            }
                        }
                    }
                    while (!memo.empty()) {
                        pair<int, int> node = memo.front();
                        memo.pop();
                        int x = node.first;
                        int y = node.second;
                        board[x][y] = 'X';
                    }
                }
            }
        }
    }
};