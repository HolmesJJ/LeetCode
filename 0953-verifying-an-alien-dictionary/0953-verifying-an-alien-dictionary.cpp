class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        if (words.size() == 1) {
            return true;
        }
        unordered_map<char, int> map;
        for (int i = 0; i < order.length(); i++) {
            map[order[i]] = i;
        }
        for (int i = 0; i < words.size() - 1; i++) {
            string w1 = words[i];
            string w2 = words[i + 1];
            int minLen = min(w1.length(), w2.length());
            int p = 0;
            while (p < minLen) {
                if (map[w1[p]] < map[w2[p]]) {
                    break;
                }
                if (map[w1[p]] > map[w2[p]]) {
                    return false;
                }
                p++;
            }
            if (p == minLen && w1.length() > w2.length()) {
                return false;
            }
        }
        return true;
    }
};