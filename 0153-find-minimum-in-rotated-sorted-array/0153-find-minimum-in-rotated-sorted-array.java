class Solution {
    public int findMin(int[] nums) {
        int pos = binarySearch(nums);
        return nums[pos];
    }

    public int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[mid] > nums[nums.length - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
