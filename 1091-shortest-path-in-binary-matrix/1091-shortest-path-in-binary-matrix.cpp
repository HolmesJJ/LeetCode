class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        int res = 0;
        
        if (grid[0][0] == 1) {
            return -1;
        }
        
        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        
        int dirs[8][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0},
                          {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        res++;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> node = q.front();
                q.pop();
                int x = node.first;
                int y = node.second;
                if (x == m - 1 && y == n - 1) {
                    return res;
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
            res++;
        }

        return -1;
    }
};