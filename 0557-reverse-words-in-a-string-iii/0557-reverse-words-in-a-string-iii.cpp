class Solution {
public:
    string reverseWords(string s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ' || i == s.size() - 1) {
                right = i == s.size() - 1 ? i : i - 1;
                while (left < right) {
                    s[left] = s[left] ^ s[right];
                    s[right] = s[left] ^ s[right];
                    s[left] = s[left] ^ s[right];
                    left++;
                    right--;
                }
                left = i + 1;
            }
        }
        return s;
    }
};