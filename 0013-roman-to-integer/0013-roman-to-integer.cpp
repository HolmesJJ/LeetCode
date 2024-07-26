class Solution {
public:
    int romanToInt(string s) {
        unordered_map<string, int> hashMap = {};
        hashMap["I"] = 1;
        hashMap["IV"] = 4;
        hashMap["V"] = 5;
        hashMap["IX"] = 9;
        hashMap["X"] = 10;
        hashMap["XL"] = 40;
        hashMap["L"] = 50;
        hashMap["XC"] = 90;
        hashMap["C"] = 100;
        hashMap["CD"] = 400;
        hashMap["D"] = 500;
        hashMap["CM"] = 900;
        hashMap["M"] = 1000;
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            string str = "";
            str.push_back(s[i]);
            if (i < s.size() - 1) {
                str.push_back(s[i + 1]);
                if (hashMap.find(str) != hashMap.end()) {
                    res += hashMap[str];
                    i++;
                } else {
                    res += hashMap[str.erase(1, 1)];
                }
            } else {
                res += hashMap[str];
            }
        }
        return res;
    }
};