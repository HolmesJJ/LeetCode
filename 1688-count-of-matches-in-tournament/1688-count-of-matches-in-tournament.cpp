class Solution {
public:
    int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            int temp = n % 2 == 1 ? n / 2 + 1 : n / 2;
            res += n / 2;
            n = temp;
        }
        return res;
    }
};