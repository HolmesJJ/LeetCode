class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int min = INT_MAX;
        int max = 0;
        for (size_t i = 0; i < prices.size(); i++) {
            min = std::min(min, prices[i]);
            max = std::max(max, prices[i] - min);
        }
        return max;
    }
};