class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid2.size();
        int n = grid2[0].size();
        
        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        
        int res = 0;
        
        int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        queue<pair<int, int>> q;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    bool isSubIsland = true;
                    q.push({i, j});
                    visited[i][j] = true;
                    if (grid1[i][j] != 1) {
                        isSubIsland = false;
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
                                if (grid2[newX][newY] == 1 && !visited[newX][newY]) {
                                    if (grid1[newX][newY] != 1) {
                                        isSubIsland = false;
                                    }
                                    q.push({newX, newY});
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                    }
                    if (isSubIsland) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
};