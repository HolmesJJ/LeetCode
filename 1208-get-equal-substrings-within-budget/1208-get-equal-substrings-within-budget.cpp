class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.size();
        vector<int> nums(n);
        for (int i = 0; i < n; i++) {
            nums[i] = abs(s[i] - t[i]);
        }
        int cost = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < n) {
            cost += nums[right];
            right++;
            while (cost > maxCost) {
                cost -= nums[left];
                left++;
            }
            maxCount = max(maxCount, right - left);
        }
        return maxCount;
    }
};