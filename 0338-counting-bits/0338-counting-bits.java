class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            f[i] = f[i - offset] + 1;
        }
        return f;
    }
}