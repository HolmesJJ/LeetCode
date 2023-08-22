class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

// 00 -> 02
// 01 -> 12
// 02 -> 22
// 10 -> 01
// 11 -> 11
// 12 -> 21
// 20 -> 00
// 21 -> 10
// 22 -> 20

// 00 -> 03
// 01 -> 13
// 02 -> 23
// 03 -> 33
// 10 -> 02
// 11 -> 12
// 12 -> 22
// 13 -> 32
