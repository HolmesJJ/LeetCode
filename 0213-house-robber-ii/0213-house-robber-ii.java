class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] f = new int[n + 1];
        f[2] = nums[1];
        for (int i = 3; i <= n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        int case1 = f[n];
        f[1] = nums[0];
        for (int i = 2; i <= n - 1; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        int case2 = f[n - 1];
        return Math.max(case1, case2);
    }
}