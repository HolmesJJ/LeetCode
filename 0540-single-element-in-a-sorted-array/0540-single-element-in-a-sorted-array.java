class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            } else if ((nums[mid - 1] == nums[mid] && nums[mid + 1] != nums[mid] && mid % 2 == 1) ||
                       (nums[mid - 1] != nums[mid] && nums[mid + 1] == nums[mid] && mid % 2 == 0)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start > 0 && nums[start - 1] == nums[start]) {
            return nums[end];
        }
        return nums[start];
    }
}

