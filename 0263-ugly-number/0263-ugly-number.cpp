class Solution {
public:
    bool isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 1) {
            bool flag = false;
            if (n >= 2 && n % 2 == 0) {
                n = n / 2;
                flag = true;
            }
            if (n >= 3 && n % 3 == 0) {
                n = n / 3;
                flag = true;
            }
            if (n >= 5 && n % 5 == 0) {
                n = n / 5;
                flag = true;
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
};