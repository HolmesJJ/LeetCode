class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        int count = 0;
        unordered_map<int, int> hashMap;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (hashMap.find(nums[i]) != hashMap.end()) {
                count += hashMap[nums[i]];
            }
            hashMap[nums[i]]++;
        }
        return count;
    }
};