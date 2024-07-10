class Solution {
public:
    int characterReplacement(string s, int k) {
        unordered_map<char, int> hashMap;
        int n = s.size();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int maxLen = 0;
        while (right < n) {
            hashMap[s[right]]++;
            maxCount = max(maxCount, hashMap[s[right]]);
            right++;
            if (right - left - maxCount <= k) {
                maxLen = max(maxLen, right - left);
            } else {
                hashMap[s[left]]--;
                left++;
            }
            
        }
        return maxLen;
    }
};