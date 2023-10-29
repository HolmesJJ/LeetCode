class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return results;
    }
    
    public void backtracking(int[] candidates, int target, int start, int total, List<Integer> result) {
        if (total == target) {
            results.add(new ArrayList<>(result));
        }
        if (total > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            result.add(candidates[i]);
            backtracking(candidates, target, i, total + candidates[i], result);
            result.remove(result.size() - 1);
        }
    }
}