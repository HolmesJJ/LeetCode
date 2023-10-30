class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] << 10;
            nums[i] = nums[i] | nums[n + i];
        }
        for (int i = 2 * n - 1; i >= 0; i = i - 2) {
            int y = nums[i / 2] & (int)(Math.pow(2, 10) - 1);
            int x = nums[i / 2] >> 10;
            nums[i] = y;
            nums[i - 1] = x;
        }
        return nums;
    }
}