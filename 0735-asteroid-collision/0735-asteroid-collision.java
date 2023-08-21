class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.size() == 0) {
                stack.push(asteroids[i]);
                continue;
            }
            if (stack.peek() * asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            if (stack.peek() < 0 && asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            while (stack.size() > 0 && stack.peek() > 0 && asteroids[i] < 0 && stack.peek() < Math.abs(asteroids[i])) {
                stack.pop();
            }
            if (stack.size() > 0 && stack.peek() > 0 && asteroids[i] < 0 && stack.peek() == Math.abs(asteroids[i])) {
                stack.pop();
            } else if (stack.size() == 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            }
        }
        int[] results = new int[stack.size()];
        for (int i = results.length - 1; i >= 0; i--) {
            results[i] = stack.pop();
        }
        return results;
    }
}