class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, int> map;
        for (size_t i = 0; i < nums.size(); i++) {
            if (map.find(nums[i]) != map.end()) {
                return true;
            } else {
                map[nums[i]] = 1;
            }
        }
        return false;
    }
};