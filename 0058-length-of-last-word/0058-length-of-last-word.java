class Solution {
    public int lengthOfLastWord(String s) {
        int p1 = -1;
        int p2 = -1;
        int res = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != ' ') {
                p2 = i;
                res = p2 - p1;
            } else {
                p1 = i;
                p2 = i;
            }
        }
        return res;
    }
}
