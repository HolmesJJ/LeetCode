class Solution {
public:
    bool isValid(string s) {
        stack<char> stack;
        for (size_t i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.top() == '(' && s[i] == ')') {
                stack.pop();
            } else if (!stack.empty() && stack.top() == '[' && s[i] == ']') {
                stack.pop();
            } else if (!stack.empty() && stack.top() == '{' && s[i] == '}') {
                stack.pop();
            } else {
                stack.push(s[i]);
            }
        }
        return stack.empty();
    }
};