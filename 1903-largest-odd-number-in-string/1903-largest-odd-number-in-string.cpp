class Solution {
public:
    string largestOddNumber(string num) {
        for (int i = num.size() - 1; i >= 0; i--) {
            if (stoi(string(1, num[i])) % 2 == 1) {
                return num.substr(0, i + 1);
            }
        }
        return "";
    }
};