class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return false;
        }
        int left = 0;
        int curr = 1;
        while (left < nums.length - 1) {
            if (nums[left] == nums[curr] && Math.abs(left - curr) <= k) {
                return true;
            }
            if (nums[left] != nums[curr] && Math.abs(left - curr) <= k) {
                if (curr < nums.length - 1) {
                    curr++;
                } else {
                    left++;
                    curr = left + 1;
                }
            } else {
                left++;
                curr = left + 1;
            }
        }
        return false;
    }
}