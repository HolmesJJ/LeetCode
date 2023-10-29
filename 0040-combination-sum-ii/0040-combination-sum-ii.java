class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return results;
    }
    
    public void backtracking(int[] candidates, int target, int start, int total, List<Integer> result) {
        if (total == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (total > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            result.add(candidates[i]);
            backtracking(candidates, target, i + 1, total + candidates[i], result);
            result.remove(result.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}