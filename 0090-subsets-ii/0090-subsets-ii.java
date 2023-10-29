class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>());
        return results;
    }
    
    public void backtracking(int[] nums, int start, List<Integer> result) {
        results.add(new ArrayList<>(result));
        for (int i = start; i < nums.length; i++) {
            result.add(nums[i]);
            backtracking(nums, i + 1, result);
            result.remove(result.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}