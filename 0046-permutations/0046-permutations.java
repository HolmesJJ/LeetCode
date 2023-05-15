class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(permutations, permutation, nums, visited);
        return permutations;
    }
    
    public void backtracking(List<List<Integer>> permutations, List<Integer> permutation, int[] nums, boolean[] visited) {
        // 收集结果，需要创建一个新的对象
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        
        // 遍历集合元素
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                // 处理结点
                permutation.add(nums[i]);
                backtracking(permutations, permutation, nums, visited);
                // 回溯操作
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}