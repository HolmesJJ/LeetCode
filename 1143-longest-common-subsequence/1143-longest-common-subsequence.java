class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();

        int m = A.length;
        int n = B.length;
        int[][] f = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (A[i - 1] == B[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[m][n];
    }
}
