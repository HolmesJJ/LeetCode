class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        vector<int> results;
        int left = low - 1;
        int right = low;
        while (left >= 0 && right < nums.size()) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (l < r) {
                results.push_back(l);
                left--;
            } else {
                results.push_back(r);
                right++;
            }
        }
        while (left >= 0) {
            int l = nums[left] * nums[left];
            results.push_back(l);
            left--;
        }
        while (right < nums.size()) {
            int r = nums[right] * nums[right];
            results.push_back(r);
            right++;
        }
        return results;
    }
};