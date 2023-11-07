class Solution {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0;
        int r = cs.length - 1;
        while (l < r) {
            if (cs[l] != cs[r]) {
                String str1 = s.substring(l + 1, r + 1);
                String str2 = s.substring(l, r);
                if (str1.equals(new StringBuffer(str1).reverse().toString()) ||
                    str2.equals(new StringBuffer(str2).reverse().toString())) {
                    return true;
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
}