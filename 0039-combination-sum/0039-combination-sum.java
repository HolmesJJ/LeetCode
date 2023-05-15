class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(combinations, combination, candidates, target, 0, 0);
        return combinations;
    }
    
    // start用来记录每次回溯操作中开始遍历的位置
    public void backtracking(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            // 收集结果，需要创建一个新的对象
            combinations.add(new ArrayList<>(combination));
            return;
        }
        // 排除大于目标元素的值
        if (sum > target) {
            return;
        }

        // 遍历集合元素
        for (int i = start; i < candidates.length; i++) {
            // 处理结点
            combination.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(combinations, combination, candidates, target, start, sum);
            // 回溯操作
            combination.remove(combination.size() - 1);
            sum = sum - candidates[i];
            // 每次处理完一个数字后，即当前数字的所有组合，则后面的组合中需要排除当前数字
            // 例如从2367中找到和为7的所有组合
            // 当2被选择且完成上面的递归和回溯操作后，代表包括2的所有组合都已经找到
            // 则后面的组合中都不应该存在2
            start++;
        }
    }
}