class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> result;
        vector<int> temp(nums.size() + 1, -1);
        for (int i = 0; i < nums.size(); i++) {
            if (temp[nums[i]] != -1) {
                result.push_back(nums[i]);
            } else {
                temp[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= nums.size(); i++) {
            if (temp[i] == -1) {
                result.push_back(i);
            }
        }
        return result;
    }
};