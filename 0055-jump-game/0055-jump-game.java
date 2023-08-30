class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 0; i < n; i++) {
            if (!f[i]) {
                return false;
            }
            int steps = nums[i];
            int j = 1;
            while (j <= steps && i + j < n) {
                f[i + j] = true;
                j++;
            }
        }
        return true;
    }
}