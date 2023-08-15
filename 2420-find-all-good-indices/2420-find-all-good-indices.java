class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                results.add(i);
            }
            return results;
        }
        int[] leftGoods = new int[nums.length];
        int[] rightGoods = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                leftGoods[i] = leftGoods[i - 1] + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                rightGoods[i] = rightGoods[i + 1] + 1;
            }
        }
        for (int i = k; i < nums.length - k; i++) {
            if (leftGoods[i - 1] >= k - 1 && rightGoods[i + 1] >= k - 1) {
                results.add(i);
            }
        }
        return results;
    }
}