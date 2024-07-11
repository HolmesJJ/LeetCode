class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int flag = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                if (flag == -1) {
                    return false;
                }
                flag = 1;
            } else if (nums[i] > nums[i + 1]) {
                if (flag == 1) {
                    return false;
                }
                flag = -1;
            }
        }
        return true;
    }
};