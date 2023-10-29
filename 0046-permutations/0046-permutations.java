class Solution {
    public List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, new ArrayList<>());
        return results;
    }

    public void backtracking(int[] nums, boolean[] visited, List<Integer> result) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            result.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited, result);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }
}