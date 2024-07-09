class Solution {
public:
    int maxVowels(string s, int k) {
        int n = s.size();
        unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.find(s[i]) != vowels.end()) {
                count++;
            }
        }
        maxCount = count;
        for (int i = k; i < n; i++) {
            if (vowels.find(s[i - k]) != vowels.end()) {
                count--;
            }
            if (vowels.find(s[i]) != vowels.end()) {
                count++;
            }
            maxCount = max(count, maxCount);
        }
        return maxCount;
    }
};