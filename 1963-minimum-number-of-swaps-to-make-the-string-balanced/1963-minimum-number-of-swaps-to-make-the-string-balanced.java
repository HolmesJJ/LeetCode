class Solution {
    public int minSwaps(String s) {
        char[] cs = s.toCharArray();
        int maxRight = 0;
        int right = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ']') {
                right++;
                maxRight = Math.max(maxRight, right);
            } else {
                right--;
            }
        }
        return (maxRight + 1) / 2;
    }
}