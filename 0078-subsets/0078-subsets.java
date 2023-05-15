class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtracking(subsets, subset, nums, 0);
        return subsets;
    }
    
    public void backtracking(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        // 收集结果，需要创建一个新的对象
        subsets.add(new ArrayList<>(subset));
        // 遍历集合元素
        for (int i = start; i < nums.length; i++) {
            // 处理结点
            subset.add(nums[i]);
            backtracking(subsets, subset, nums, i + 1);
            // 回溯操作
            subset.remove(subset.size() - 1);
        }
    }
}