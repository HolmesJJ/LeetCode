class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int x = element[0];
            int y = element[1];
            for (int i = 0; i < n; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}