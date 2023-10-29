class Solution {
    boolean isWord = false;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    backtracking(board, visited, i, j, board[i][j] + "", word);
                    if (isWord) {
                        return true;
                    }
                }
            }
        }
        return isWord;
    }
    
    public void backtracking(char[][] board, boolean[][] visited, int x, int y, String result, String word) {
        if (result.equals(word)) {
            isWord = true;
            return;
        }
        if (result.length() > word.length()) {
            return;
        }
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {
                visited[newX][newY] = true;
                backtracking(board, visited, newX, newY, result + board[newX][newY], word);
                visited[newX][newY] = false;
            }
        }
    }
}