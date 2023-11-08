class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                Set<Character> set = new HashSet<>();
                for (int i = a * 3; i < a * 3 + 3; i++) {
                    for (int j = b * 3; j < b * 3 + 3; j++) {
                        if (board[i][j] != '.') {
                            if (set.contains(board[i][j])) {
                                return false;
                            }
                            set.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}