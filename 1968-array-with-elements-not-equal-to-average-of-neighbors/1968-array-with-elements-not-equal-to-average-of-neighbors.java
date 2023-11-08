class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[l];
                l++;
            } else {
                res[i] = nums[r];
                r--;
            }
        }
        return res;
    }
}