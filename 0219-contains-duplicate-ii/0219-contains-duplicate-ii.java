class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}