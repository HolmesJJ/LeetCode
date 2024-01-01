class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        int m = board.size();
        int n = board[0].size();
        
        int dirs[8][2] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        for (auto& dir : dirs) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '.' && board[x][y] != color) {
                while (true) {
                    x = x + dir[0];
                    y = y + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        break;
                    }
                    if (board[x][y] == color) {
                        return true;
                    }
                    if (board[x][y] != (color == 'B' ? 'W' : 'B')) {
                        break;
                    }
                }
            }
        }

        return false;
    }
};