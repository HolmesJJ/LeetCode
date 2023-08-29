class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    Collections.sort(result);
                    map.put("" + result.get(0) + result.get(1) + result.get(2), result);
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        List<List<Integer>> results = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }
}
