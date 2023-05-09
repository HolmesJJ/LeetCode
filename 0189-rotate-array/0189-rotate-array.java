class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        int[] tmp = new int[l];
        for (int i = 0; i < l; i++) {
            if (l - k + i < l) {
                tmp[i] = nums[l - k + i];
            } else {
                tmp[i] = nums[i - k];
            }
        }
        for (int i = 0; i < l; i++) {
            nums[i] = tmp[i];
        }
    }
}
