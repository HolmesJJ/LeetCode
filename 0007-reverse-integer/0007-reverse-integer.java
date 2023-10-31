class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            int tmp = res * 10 + digit;
            if (res != (tmp - digit) / 10) {
                return 0;
            }
            res = res * 10 + digit;
        }
        return res;
    }
}