class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        List<Integer> results = new ArrayList<>();
        int currLength = results.size();

        int row = 0;
        int col = n - 1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < m * n + 10) {
            // left -> right
            while (j < n) {
                if (!visited[row][j]) {
                    results.add(matrix[row][j]);
                    count++;
                    visited[row][j] = true;
                } else {
                    j--;
                    break;
                }
                j++;
            }
            j = Math.min(j, n - 1);
            col = j;
            row = row + 1;
            i = row;
            if (currLength == results.size()) {
                return results;
            } else {
                currLength = results.size();
            }
            // up -> down
            while (i < m) {
                if (!visited[i][col]) {
                    results.add(matrix[i][col]);
                    count++;
                    visited[i][col] = true;
                } else {
                    i--;
                    break;
                }
                i++;
            }
            i = Math.min(i, m - 1);
            row = i;
            col = col - 1;
            j = col;
            if (currLength == results.size()) {
                return results;
            } else {
                currLength = results.size();
            }
            // right -> left
            while (j >= 0) {
                if (!visited[row][j]) {
                    results.add(matrix[row][j]);
                    count++;
                    visited[row][j] = true;
                } else {
                    j++;
                    break;
                }
                j--;
            }
            j = Math.max(j, 0);
            col = j;
            row = row - 1;
            i = row;
            if (currLength == results.size()) {
                return results;
            } else {
                currLength = results.size();
            }
            // down -> up
            while (i >= 0) {
                if (!visited[i][col]) {
                    results.add(matrix[i][col]);
                    count++;
                    visited[i][col] = true;
                } else {
                    i++;
                    break;
                }
                i--;
            }
            i = Math.max(i, 0);
            row = i;
            col = col + 1;
            j = col;
            if (currLength == results.size()) {
                return results;
            } else {
                currLength = results.size();
            }
        }
        return results;
    }
}