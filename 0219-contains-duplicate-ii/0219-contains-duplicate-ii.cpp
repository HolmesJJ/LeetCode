class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> hashMap;
        for (int i = 0; i < n; i++) {
            if (hashMap.find(nums[i]) == hashMap.end()) {
                hashMap[nums[i]] = i;
            } else {
                if (abs(hashMap[nums[i]] - i) <= k) {
                    return true;
                }
                hashMap[nums[i]] = i;
            }
        }
        return false;
    }
};