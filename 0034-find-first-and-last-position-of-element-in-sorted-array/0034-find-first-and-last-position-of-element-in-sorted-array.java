class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pos = -1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            pos = start;
        }
        if (nums[end] == target) {
            pos = end;
        }
        if (pos == -1) {
            return new int[]{-1, -1};
        }
        int left = pos;
        int right = pos;
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }
}