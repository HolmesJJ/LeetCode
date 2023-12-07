class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        vector<vector<int>> res = {};
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<bool>> memo(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(heights, memo, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j]) {
                    res.push_back({i, j});
                }
            }
        }
        return res;
    }
    
    void bfs(vector<vector<int>>& heights, vector<vector<bool>>& memo, int sourceX, int sourceY) {
        int m = heights.size();
        int n = heights[0].size();
        
        bool visited[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        
        int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue<pair<int, int>> q;
        
        q.push({sourceX, sourceY});
        visited[sourceX][sourceY] = true;
        bool isPacific = false;
        bool isAtlantic = false;
        if (sourceX == 0 || sourceY == 0) {
            isPacific = true;
        }
        if (sourceX == m - 1 || sourceY == n - 1) {
            isAtlantic = true;
        }
        if (isPacific && isAtlantic) {
            memo[sourceX][sourceY] = isPacific && isAtlantic;
            q = {};
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
                    if (!visited[newX][newY] && heights[x][y] >= heights[newX][newY]) {
                        q.push({newX, newY});
                        visited[newX][newY] = true;
                        if (newX == 0 || newY == 0) {
                            isPacific = true;
                        }
                        if (newX == m - 1 || newY == n - 1) {
                            isAtlantic = true;
                        }
                        if (memo[newX][newY]) {
                            memo[sourceX][sourceY] = true;
                            q = {};
                            break;
                        }
                        if (isPacific && isAtlantic) {
                            memo[sourceX][sourceY] = isPacific && isAtlantic;
                            q = {};
                            break;
                        }
                    }
                }
            }
        }
    }
};