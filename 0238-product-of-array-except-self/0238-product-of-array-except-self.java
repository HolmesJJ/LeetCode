class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] postfixes = new int[nums.length];
        prefixes[0] = nums[0];
        postfixes[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            postfixes[i] = postfixes[i + 1] * nums[i];
        }
        int[] results = new int[nums.length];
        results[0] = postfixes[1];
        results[nums.length - 1] = prefixes[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            results[i] = prefixes[i - 1] * postfixes[i + 1];
        }
        return results;
    }
}
