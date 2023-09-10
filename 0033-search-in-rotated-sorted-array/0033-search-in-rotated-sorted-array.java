class Solution {
    public int search(int[] nums, int target) {
        int pos = binarySearch(nums, target);
        return pos;
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if ((nums[mid] > nums[nums.length - 1] && (nums[mid] < target || target <= nums[nums.length - 1])) ||
                       (nums[mid] <= nums[nums.length - 1]) && target <= nums[nums.length - 1] && nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}




    // public int binarySearch(int[] nums, int target, int low, int high) {
    //     if (low > high) {
    //         return low;
    //     }
    //     int mid = low + (high - low) / 2;
    //     if ((nums[mid] > nums[nums.length - 1] && (target > nums[mid] || target <= nums[nums.length - 1])) ||
    //         (nums[mid] <= nums[nums.length - 1] && target <= nums[nums.length - 1] && nums[mid] < target)) {
    //         return binarySearch(nums, target, mid + 1, high);
    //     } else {
    //         return binarySearch(nums, target, low, mid - 1);
    //     }
    // }