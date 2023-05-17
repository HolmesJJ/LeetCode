class Solution {
    public int search(int[] nums, int target) {
        int pos = binarySearch(nums, target, 0, nums.length - 1);
        if (pos == nums.length || nums[pos] != target) {
            return -1;
        }
        return pos;
    }
    
    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if ((nums[mid] > nums[nums.length - 1] && (target > nums[mid] || target <= nums[nums.length - 1])) ||
            (nums[mid] <= nums[nums.length - 1] && target <= nums[nums.length - 1] && nums[mid] < target)) {
            return binarySearch(nums, target, mid + 1, high);
        } else {
            return binarySearch(nums, target, low, mid - 1);
        }
    }
}