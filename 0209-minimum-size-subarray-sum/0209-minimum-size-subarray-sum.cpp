class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        int left = 0;
        int right = 0;
        int sum = 0;
        int minDist = INT_MAX;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                minDist = min(minDist, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minDist == INT_MAX ? 0 : minDist;
    }
};