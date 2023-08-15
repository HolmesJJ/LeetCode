class Solution {
    public boolean checkPossibility(int[] nums) {
        int countUpdate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (countUpdate > 0) {
                    return false;
                }
                if (i > 1) {
                    if (nums[i - 2] > nums[i]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = nums[i];
                    }
                } else {
                    nums[i - 1] = nums[i];
                }
                countUpdate++;
            }
        }
        return true;
    }
}
