class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> hashMap;
        int n = s.size();
        int left = 0;
        int right = 0;
        int len = 0;
        int maxLen = 0;
        while (right < n) {
            if (hashMap.find(s[right]) != hashMap.end()) {
                if (hashMap[s[right]] >= left) {
                    left = hashMap[s[right]] + 1;
                }
            }
            hashMap[s[right]] = right;
            right++;
            maxLen = max(maxLen, right - left);
        }
        return maxLen;
    }
};