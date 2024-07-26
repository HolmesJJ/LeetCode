class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        int size = m * n;
        int pos = size - k % size;
        cout << pos << endl;
        queue<int> q = {};
        int start = 0;
        int end = pos;
        while (pos < m * n) {
            q.push(grid[pos / n][pos % n]);
            pos++;
        }
        while (start < end) {
            q.push(grid[start / n][start % n]);
            start++;
        }
        start = 0; 
        while (!q.empty()) {
            grid[start / n][start % n] = q.front();
            q.pop();
            start++;
        }
        return grid;
    }
};