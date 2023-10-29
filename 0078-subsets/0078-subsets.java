class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, new ArrayList<>(), 0);
        return results;
    }
    
    public void backtracking(int[] nums, List<Integer> result, int start) {
        results.add(new ArrayList<>(result));
        for (int i = start; i < nums.length; i++) {
            result.add(nums[i]);
            backtracking(nums, result, i + 1);
            result.remove(result.size() - 1);
        }
    }
}