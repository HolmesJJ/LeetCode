class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        for (auto word : words) {
            int left = 0;
            int right = word.size() - 1;
            bool flag = true;
            while (left < right) {
                if (word[left] != word[right]) {
                    flag = false;
                    break;
                }
                left++;
                right--;
            }
            if (flag) {
                return word;
            }
        }
        return "";
    }
};