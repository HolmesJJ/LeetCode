class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] results = new int[temperatures.length];
        Stack<Integer> posStack = new Stack<>();
        Stack<Integer> diffStack = new Stack<>();
        for (int i = 0; i < temperatures.length - 1; i++) {
            int diff = temperatures[i + 1] - temperatures[i];
            if (diff <= 0) {
                posStack.add(i);
                diffStack.add(diff);
            } else {
                results[i] = 1;
                while (!diffStack.isEmpty() && diff > 0) {
                    int val = diffStack.pop();
                    diff = val + diff;
                    if (diff > 0) {
                        int pos = posStack.pop();
                        results[pos] = i - pos + 1;
                    } else {
                        diffStack.add(diff);
                    }
                    
                }
            }
        }
        results[temperatures.length - 1] = 0;
        return results;
    }
}