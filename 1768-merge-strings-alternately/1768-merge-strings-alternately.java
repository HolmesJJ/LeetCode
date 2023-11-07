class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        char[] ws1 = word1.toCharArray();
        char[] ws2 = word2.toCharArray();
        int i = 0;
        int j = 0;
        boolean flag = true;
        while (i < ws1.length && j < ws2.length) {
            if (flag) {
                res = res + ws1[i];
                i++;
            } else {
                res = res + ws2[j];
                j++;
            }
            flag = !flag;
        }
        while (i < ws1.length) {
            res = res + ws1[i];
            i++;
        }
        while (j < ws2.length) {
            res = res + ws2[j];
            j++;
        }
        return res;
    }
}