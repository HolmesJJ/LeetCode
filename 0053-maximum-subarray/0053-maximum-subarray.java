class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}