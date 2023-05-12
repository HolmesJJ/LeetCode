class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            if (leftSum == rightSum) {
                return i - 1;
            }
            leftSum += nums[i - 1];
            rightSum -= nums[i];
        }
        if (leftSum == rightSum) {
            return nums.length - 1;
        }
        return -1;
    }
}