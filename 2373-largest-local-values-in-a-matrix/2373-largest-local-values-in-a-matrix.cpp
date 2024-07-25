class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = m - 2;
        vector<vector<int>> nm(n, vector<int>(n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxVal = grid[i][j];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        maxVal = max(maxVal, grid[i + k][j + l]);
                    }
                }
                nm[i][j] = maxVal;
            }
        }
        return nm;
    }
};