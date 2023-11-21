class Solution {
public:
    bool isAnagram(string s, string t) {
        char *cs = &s[0];
        char *ts = &t[0];
        unordered_map<char, int> map;
        for (size_t i = 0; i < s.length(); i++) {
            if (map.find(cs[i]) == map.end()) {
                map[cs[i]] = 1;
            } else {
                map[cs[i]] = map[cs[i]] + 1;
            }
        }
        for (size_t i = 0; i < t.length(); i++) {
            if (map.find(ts[i]) == map.end() || map[ts[i]] == 0) {
                return false;
            }
            map[ts[i]] = map[ts[i]] - 1;
            if (map[ts[i]] == 0) {
                map.erase(t[i]);
            }
        }
        return map.size() == 0;
    }
};