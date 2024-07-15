class Solution {
public:
    bool makeEqual(vector<string>& words) {
        unordered_map<char, int> hashMap;
        int count = 0;
        for (auto word : words) {
            for (auto c : word) {
                hashMap[c]++;
            }
            count += word.size();
        }
        if (count % words.size() != 0) {
            return false;
        }
        for (auto it : hashMap) {
            if (it.second % words.size() != 0) {
                return false;
            }
        }
        return true;
    }
};