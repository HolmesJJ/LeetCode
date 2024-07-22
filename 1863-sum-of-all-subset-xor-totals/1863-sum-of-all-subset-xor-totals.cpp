class Solution {
public:
    int total = 0;

    int subsetXORSum(vector<int>& nums) {
        int currentXOR = 0;
        backtracking(nums, 0, currentXOR);
        return total;
    }

    void backtracking(vector<int>& nums, int start, int currentXOR) {
        total += currentXOR;
        for (int i = start; i < nums.size(); i++) {
            backtracking(nums, i + 1, currentXOR ^ nums[i]);
        }
    }
};