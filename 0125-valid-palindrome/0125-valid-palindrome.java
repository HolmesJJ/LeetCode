class Solution {
    public boolean isPalindrome(String s) {
        char[] sChars = s.toCharArray();
        String t = "";
        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                t += c;
            }
        }
        t = t.toLowerCase();
        char[] tChars = t.toCharArray();
        int left = 0;
        int right = tChars.length - 1;
        while (left < right) {
            if (tChars[left] != tChars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}