class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        char[] ns = num.toCharArray();
        for (int i = 0; i < ns.length; i++) {
            while (!stack.isEmpty() && stack.peek() > ns[i] - '0' && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ns[i] - '0');
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        int start = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.substring(i, i + 1).equals("0")) {
                start++;
            } else {
                break;
            }
        }
        if (start == res.length()) {
            return "0";
        } else {
            return res.substring(start, res.length());
        }
    }
}