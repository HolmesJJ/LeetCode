class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        int i = 1;
        int j = 0;
        int max = 1;
        while (i <= n) {
            if (i == max) {
                max = max * 2;
                j = 0;
            }
            f[i] = f[j] + 1;
            i++;
            j++;
        }
        return f;
    }
}

// 0 00   0
// 1 01   1
// 2 10   1
// 3 11   2
// 4 100  3
// 5 101  3