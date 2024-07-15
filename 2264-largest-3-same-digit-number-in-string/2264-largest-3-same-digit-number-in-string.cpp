class Solution {
public:
    string largestGoodInteger(string num) {
        string result = "";
        for (int i = 0; i < num.size() - 2; i++) {
            if (num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
                if (result == "" || stoi(result) < stoi(num.substr(i, 3))) {
                    result = num.substr(i, 3);
                }
            }
        }
        return result;
    }
};