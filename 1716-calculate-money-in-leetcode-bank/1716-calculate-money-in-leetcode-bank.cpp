class Solution {
public:
    int totalMoney(int n) {
        int res = 0;
        int start = 0;
        for (int i = 1; i <= n; i++) {
            res += (i % 7 == 0 ? 7 : i % 7) + start;
            if (i % 7 == 0) {
                start++;
            }
        }
        return res;
    }
};