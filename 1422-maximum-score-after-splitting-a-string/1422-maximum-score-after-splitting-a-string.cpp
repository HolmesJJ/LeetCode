class Solution {
public:
    int maxScore(string s) {
        int n = s.size();
        int left = s[0] == '0' ? 1 : 0;
        int right = 0;
        int score = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == '1') {
                right++;
            }
        }
        score = left + right;
        for (int i = 1; i < n - 1; i++) {
            if (s[i] == '0') {
                left++;
            } else {
                right--;
            }
            score = max(score, left + right);
        }
        return score;
    }
};