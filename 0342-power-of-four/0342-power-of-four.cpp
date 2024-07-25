class Solution {
public:
    bool isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 4) {
            return false;
        }
        while (n > 0) {
            if (n % 4 != 0) {
                return false;
            }
            if (n / 4 == 1) {
                return n % 4 == 0;
            }
            n = n / 4;
        }
        return false;
    }
};