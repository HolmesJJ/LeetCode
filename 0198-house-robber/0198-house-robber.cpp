class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1) {
            return nums[0];
        }
        if (n <= 2) {
            return max(nums[0], nums[1]);
        }
        vector<int> f(n);
        f[0] = nums[0];
        f[1] = nums[1];
        for (int i = 2; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i - 1; j++) {
                temp = max(temp, f[j] + nums[i]);
            }
            f[i] = max(temp, f[i - 1]);
        }
        return f[n - 1];
    }
};