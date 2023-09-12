class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxFrequency = 1;
        long total = 0;
        for (int right = 1; right < n; ++right) {
            total += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (total > k) {
                total -= nums[right] - nums[left];
                ++left;
            }
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }
        return maxFrequency;
    }
}