class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        int max = 1;
        int pointer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == max) {
                max = max * 2;
                pointer = 0;
            }
            f[i] = f[pointer] + 1;
            pointer++;
        }
        return f;
    }
}