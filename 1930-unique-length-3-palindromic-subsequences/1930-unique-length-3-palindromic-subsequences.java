class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] cs = s.toCharArray();
        Set<Character> leftSet = new HashSet<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        Set<String> res = new HashSet<>();
        leftSet.add(cs[0]);
        for (int i = 2; i < cs.length; i++) {
            rightMap.put(cs[i], rightMap.getOrDefault(cs[i], 0) + 1);
        }
        for (int i = 1; i < cs.length - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (leftSet.contains((char)('a' + j)) && rightMap.containsKey((char)('a' + j))) {
                    res.add("" + (char)('a' + j) + cs[i] + (char)('a' + j));
                }
            }
            leftSet.add(cs[i]);
            if (rightMap.get(cs[i + 1]) == 1) {
                rightMap.remove(cs[i + 1]);
            } else {
                rightMap.put(cs[i + 1], rightMap.get(cs[i + 1]) - 1);
            }
        }
        return res.size();
    }
}