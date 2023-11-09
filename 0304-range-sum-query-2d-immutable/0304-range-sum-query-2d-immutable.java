class NumMatrix {
    
    public int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sumMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = 0;
        int total = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 > 0) {
                left = left + sumMatrix[i][col1 - 1];
            }
            total = total + sumMatrix[i][col2];
        }
        return total - left;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */