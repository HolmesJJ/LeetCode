class Solution {
    public int findMin(int[] nums) {
        int index = binarySearch(nums, 0, nums.length - 1);
        return nums[index];
    }
    
    public int binarySearch(int[] nums, int low, int high) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] >= nums[0] && nums[mid] > nums[nums.length - 1]) {
            return binarySearch(nums, mid + 1, high);
        } else {
            return binarySearch(nums, low, mid - 1);
        }
    }
}
