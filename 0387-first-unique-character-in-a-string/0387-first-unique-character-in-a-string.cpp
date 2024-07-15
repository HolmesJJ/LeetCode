class Solution {
public:
    int firstUniqChar(string s) {
        int result = -1;
        unordered_map<char, int> hashMap;
        for (int i = 0; i < s.size(); i++) {
            hashMap[s[i]]++;
        }
        for (int i = 0; i < s.size(); i++) {
            if (hashMap[s[i]] == 1) {
                return i;
            }
        }
        return result;
    }
};
