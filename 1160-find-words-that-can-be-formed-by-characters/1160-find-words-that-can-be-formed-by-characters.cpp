class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        unordered_map<char, int> hashMap1;
        for (int i = 0; i < chars.size(); i++) {
            hashMap1[chars[i]]++;
        }
        int count = 0;
        for (auto word : words) {
            unordered_map<char, int> hashMap2;
            for (int i = 0; i < word.size(); i++) {
                hashMap2[word[i]]++;
            }
            bool flag = true;
            for (auto it : hashMap2) {
                if (hashMap1[it.first] < it.second) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += word.size();
            }
        }
        return count;
    }
};