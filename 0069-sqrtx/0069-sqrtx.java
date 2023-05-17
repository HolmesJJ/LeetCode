class Solution {
    public int mySqrt(int x) {
        int target = binarySearch(x, 0, x);
        return (long) target * target > x ? target - 1 : target;
    }
    
    public int binarySearch(int x, int low, int high) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if ((long) mid * mid < x) {
            return binarySearch(x, low + 1, high);
        } else {
            return binarySearch(x, low, mid - 1);
        }
    }
}