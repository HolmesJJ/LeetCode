class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        unordered_map<string, string> hashMap;
        for (auto path : paths) {
            hashMap[path[0]] = path[1];
        }
        for (auto it : hashMap) {
            if (hashMap.find(it.second) == hashMap.end()) {
                return it.second;
            }
        }
        return "";
    }
};