class Solution {
    public int partitionString(String s) {
        char[] ss = s.toCharArray();
        int res = 1;
        Set<Character> set = new HashSet<>();
        set.add(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            if (set.contains(ss[i])) {
                set.clear();
                res++;
            }
            set.add(ss[i]);
        }
        return res;
    }
}