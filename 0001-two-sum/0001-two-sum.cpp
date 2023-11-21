class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        unordered_map<int, int> map;
        for (size_t i = 0; i < nums.size(); i++) {
            map[target - nums[i]] = i;
        }
        for (size_t i = 0; i < nums.size(); i++) {
            if (map.find(nums[i]) != map.end() && map[nums[i]] != i) {
                res.push_back(i);
                res.push_back(map[nums[i]]);
                break;
            }
        }
        return res;
    }
};