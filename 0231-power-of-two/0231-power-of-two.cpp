class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int numBits = sizeof(n) * 8;
        int count1 = 0;
        for (int i = numBits - 1; i >= 0; i--) {
            if ((n >> i) & 1 == 1) {
                count1++;
            }
            if (count1 > 1) {
                return false;
            }
        }
        return true;
    }
};

// 0: 0
// 2: 10
// 4: 100
// 8: 1000
// 16: 10000