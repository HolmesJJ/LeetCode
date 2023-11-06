class Solution {
    public int bestClosingTime(String customers) {
        char[] ss = customers.toCharArray();
        int[] prefixes = new int[ss.length];
        int[] postfixes = new int[ss.length];
        int prefix = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == 'N') {
                prefix++;
            }
            prefixes[i] = prefix;
        }
        int postfix = 0;
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i] == 'Y') {
                postfix++;
            }
            postfixes[i] = postfix;
        }
        int min = 0;
        int res = postfixes[0];
        for (int i = 1; i < ss.length; i++) {
            if (res > prefixes[i - 1] + postfixes[i]) {
                res = prefixes[i - 1] + postfixes[i];
                min = i;
            }
        }
        if (res > prefixes[ss.length - 1]) {
            res = prefixes[ss.length - 1];
            min = ss.length;
        }
        return min;
    }
}