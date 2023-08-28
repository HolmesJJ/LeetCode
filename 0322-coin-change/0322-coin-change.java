class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE && f[i - coins[j]] + 1 < f[i]) {
                    f[i] = f[i - coins[j]] + 1;
                }
            }
        }
        if (f[n] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return f[n];
        }
    }
}
