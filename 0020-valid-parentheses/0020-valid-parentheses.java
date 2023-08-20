class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == ')' ||
                chars[i] == '{' || chars[i] == '}' ||
                chars[i] == '[' || chars[i] == ']') {
                if (stack.size() > 0 && map.containsKey(stack.peek()) && map.get(stack.peek()) == chars[i]) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.size() == 0;
    }
}
