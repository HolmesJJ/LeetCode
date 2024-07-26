class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        int m = img.size();
        int n = img[0].size();
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
                                    {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        vector<vector<int>> newImg(m, vector<int>(n));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int count = 1;
                for (auto dir : dirs) {
                    if (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n) {
                        sum += img[i + dir[0]][j + dir[1]];
                        count++;
                    }
                }
                int avg = sum / count;
                newImg[i][j] = avg;
            }
        }
        return newImg;
    }
};