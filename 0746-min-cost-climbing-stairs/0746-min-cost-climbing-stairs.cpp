class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> f = {};
        f.push_back(cost[0]);
        f.push_back(cost[1]);
        int n = cost.size();
        for (int i = 2; i < n; i++) {
            f.push_back(min(f[i - 1], f[i - 2]) + cost[i]);
        }
        return min(f[n - 1], f[n - 2]);
    }
};