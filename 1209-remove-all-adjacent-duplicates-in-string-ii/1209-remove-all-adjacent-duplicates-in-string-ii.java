class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (!stack.isEmpty()) {
                Pair<Character, Integer> top = stack.peek();
                if (top.getKey() == ss[i]) {
                    stack.pop();
                    if (top.getValue() + 1 < k) {
                        stack.push(new Pair<>(top.getKey(), top.getValue() + 1));
                    }
                } else {
                    stack.push(new Pair<>(ss[i], 1));
                }
            } else {
                stack.push(new Pair<>(ss[i], 1));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> current = stack.pop();
            for (int i = 0; i < current.getValue(); i++) {
                res.insert(0, current.getKey());
            }
        }
        return res.toString();
    }
}