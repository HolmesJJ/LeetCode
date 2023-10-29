class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1, new ArrayList<>());
        return results;
    }
    
    public void backtracking(int n, int k, int start, List<Integer> result) {
        if (result.size() == k) {
            results.add(new ArrayList<>(result));
        }
        if (result.size() > k) {
            return;
        }
        for (int i = start; i <= n; i++) {
            result.add(i);
            backtracking(n, k, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
}