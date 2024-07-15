class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int maxLen = -1;
        unordered_map<char, int> hashMap;
        for (int i = 0; i < s.size(); i++) {
            if (hashMap.find(s[i]) == hashMap.end()) {
                hashMap[s[i]] = i;
            } else {
                maxLen = max(maxLen, i - hashMap[s[i]] - 1);
            }
        }
        return maxLen;
    }
};