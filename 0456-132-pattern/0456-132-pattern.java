class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = nums[0];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{nums[0], min});
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (nums[i] >= top[0]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (nums[i] > top[1]) {
                    return true;
                }
            }
            stack.push(new int[]{nums[i], min});
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}