class Solution {
public:
    int maxDepth(string s) {
        stack<int> st;
        int res = 0;
        for (auto c : s) {
            if (c == '(') {
                st.push(c);
                int depth = st.size();
                res = max(res, depth);
            } else if (c == ')') {
                st.pop();
            }
        }
        return res;
    }
};