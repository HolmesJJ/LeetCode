class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1 || k <= 1 || k > nums.length) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length + 1 - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        return minDiff;
    }
}