class Solution {
    public int arraySign(int[] nums) {
        int countNegative = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < 0) {
                countNegative++;
            }
            if (nums[i] == 0) {
                return 0;
            }
        }
        if (countNegative % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}