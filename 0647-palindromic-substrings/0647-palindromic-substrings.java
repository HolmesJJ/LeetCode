class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        
        // 以每个字符为开头查找每种可能是否回文串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}