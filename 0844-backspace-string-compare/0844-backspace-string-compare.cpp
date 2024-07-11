class Solution {
public:
    bool backspaceCompare(string s, string t) {
        int p1 = 0;
        string newS = "";
        while (p1 < s.size()) {
            if (s[p1] == '#') {
                if (newS.size() > 0) {
                    newS.erase(newS.size() - 1, 1);
                }
            } else {
                newS += s[p1];
            }
            p1++;
        }
        int p2 = 0;
        string newT = "";
        while (p2 < t.size()) {
            if (t[p2] == '#') {
                if (newT.size() > 0) {
                    newT.erase(newT.size() - 1, 1);
                }
            } else {
                newT += t[p2];
            }
            p2++;
        }
        return newS == newT;
    }
};