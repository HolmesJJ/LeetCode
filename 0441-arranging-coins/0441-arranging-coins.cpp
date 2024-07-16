class Solution {
public:
    int arrangeCoins(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((1 + mid) * 1.0 / 2 < n * 1.0 / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (1 + low) * 1.0 / 2 == n * 1.0 / low ? low : low - 1;
    }
};