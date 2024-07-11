class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size();
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < n) {
            while (p1 < n && nums[p1] % 2 == 0) {
                p1++;
            }
            if (p2 < p1) {
                p2 = p1;
            }
            while (p2 < n && nums[p2] % 2 == 1) {
                p2++;
            }
            if (p1 < n && p2 < n) {
                nums[p1] = nums[p1] ^ nums[p2];
                nums[p2] = nums[p1] ^ nums[p2];
                nums[p1] = nums[p1] ^ nums[p2];
            }
        }
        return nums;
    }
};