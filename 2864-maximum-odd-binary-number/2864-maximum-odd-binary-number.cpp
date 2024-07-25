class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < s.size() - 1) {
            if (s[p2] == '1') {
                if (s[s.size() - 1] == '0') {
                    s[s.size() - 1] = '1';
                    s[p2] = '0';
                } else {
                    while (p1 < p2 && s[p1] == '1') {
                        p1++;
                    }
                    if (s[p1] == '0') {
                        s[p1] = '1';
                        s[p2] = '0';
                    }
                }
            }
            p2++;
        }
        return s;
    }
};