class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> trustCount(n + 1, 0);
        vector<int> trustedByCount(n + 1, 0);
        int m = trust.size();
        for (int i = 0; i < m; i++) {
            trustCount[trust[i][0]]++;
            trustedByCount[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustedByCount[i] == n - 1 && trustCount[i] == 0) {
                return i;
            }
        }
        return -1;
    }
};