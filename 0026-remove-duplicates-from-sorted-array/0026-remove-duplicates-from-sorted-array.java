class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int cur = 1;
        while (cur < nums.length) {
            if (nums[cur - 1] != nums[cur]) {
                prev++;
                nums[prev] = nums[cur];
            }
            cur++;
        }
        return prev + 1;
    }
}