class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res = "";
        while (columnNumber > 0) {
            columnNumber--;
            char currentChar = 'A' + (columnNumber % 26);
            res = currentChar + res;
            columnNumber /= 26;
        }
        return res;
    }
};