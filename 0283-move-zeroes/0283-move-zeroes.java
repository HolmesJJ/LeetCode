class Solution {
    public void moveZeroes(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zero == -1) {
                zero = i;
            }
            if (nums[i] != 0 && zero != -1) {
                nums[zero] = nums[i];
                nums[i] = 0;
                while (nums[zero] != 0 && zero < nums.length) {
                    zero++;
                }
            }
        }
    }
}