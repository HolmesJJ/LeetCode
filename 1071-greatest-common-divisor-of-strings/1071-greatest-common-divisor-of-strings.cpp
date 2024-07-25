class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        int p1 = str1.size();
        vector<string> strs1 = {};
        while (p1 > 0) {
            string subStr1 = str1.substr(0, p1);
            string temp = "";
            while (temp.size() < str1.size()) {
                temp = temp + subStr1;
            }
            if (temp == str1) {
                strs1.push_back(subStr1);
            }
            p1--;
        }
        for (auto subStr1 : strs1) {
            string temp = "";
            while (temp.size() < str2.size()) {
                temp = temp + subStr1;
            }
            if (temp == str2) {
                return subStr1;
            }
        }
        return "";
    }
};