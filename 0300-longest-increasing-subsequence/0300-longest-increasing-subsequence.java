class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + ", ");
        }
        return max;
    }
}