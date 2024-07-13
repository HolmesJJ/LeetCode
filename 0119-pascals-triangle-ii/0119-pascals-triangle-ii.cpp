class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> results;
        results.push_back({1});
        results.push_back({1, 1});
        for (int i = 2; i <= rowIndex; i++) {
            vector<int> result;
            result.push_back(1);
            for (int j = 0; j < results[i - 1].size() - 1; j++) {
                result.push_back(results[i - 1][j] + results[i - 1][j + 1]);
            }
            result.push_back(1);
            results.push_back(result);
        }
        return results[rowIndex];
    }
};