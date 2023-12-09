class Solution {
public:
    int snakesAndLadders(vector<vector<int>> &board) {
        int n = board.size();
        vector<pair<int, int>> cells(n * n + 1);
        bool dir = true;
        int index = 1;
        for (int row = n - 1; row >= 0; row--) {
            if (dir) {
                for (int col = 0; col < n; col++) {
                    cells[index++] = {row, col};
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    cells[index++] = {row, col};
                }
            }
            dir = !dir;
        }
        
        vector<int> dist(n * n + 1, -1);
        dist[1] = 0; // 记录到每个编号的最短距离
        queue<int> q;
        q.push(1);
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            if (node == n * n) {
                return dist[node];
            };
            for (int next = node + 1; next <= min(node + 6, n * n); next++) {
                auto [r, c] = cells[next];
                int destination = board[r][c] == -1 ? next : board[r][c];
                if (dist[destination] == -1) {
                    dist[destination] = dist[node] + 1;
                    q.push(destination);
                }
            }
        }
        return dist[n * n];
    }
};