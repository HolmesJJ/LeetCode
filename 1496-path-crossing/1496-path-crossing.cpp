class Solution {
public:
    bool isPathCrossing(string path) {
        vector<int> pos = {0, 0};
        unordered_set<string> hashSet;
        hashSet.insert(to_string(pos[0]) + "," + to_string(pos[1]));
        for (auto dir : path) {
            if (dir == 'N') {
                pos[0]++;
            } else if (dir == 'S') {
                pos[0]--;
            } else if (dir == 'E') {
                pos[1]++;
            } else {
                pos[1]--;
            }
            if (hashSet.find(to_string(pos[0]) + "," + to_string(pos[1])) != hashSet.end()) {
                return true;
            }
            hashSet.insert(to_string(pos[0]) + "," + to_string(pos[1]));
        }
        return false;
    }
};