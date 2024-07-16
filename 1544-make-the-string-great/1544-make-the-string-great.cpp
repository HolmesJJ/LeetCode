class Solution {
public:
    string makeGood(string s) {
        string result = "";
        stack<char> st;
        for (auto c : s) {
            if (st.empty()) {
                st.push(c);
            } else {
                if ((islower(st.top()) && islower(c)) || (isupper(st.top()) && isupper(c))) {
                    st.push(c);
                } else {
                    if ((tolower(st.top()) == tolower(c))) {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                }
            }
        }
        while (!st.empty()) {
            char top = st.top();
            st.pop();
            result = top + result;
        }
        return result;
    }
};