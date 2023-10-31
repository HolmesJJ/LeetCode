class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            map.put(ss[i], map.getOrDefault(ss[i], 0) + 1);
        }
        for (int i = 0; i < ts.length; i++) {
            if (!map.containsKey(ts[i])) {
                return false;
            }
            map.put(ts[i], map.get(ts[i]) - 1);
            if (map.get(ts[i]) == 0) {
                map.remove(ts[i]);
            }
        }
        return map.size() == 0;
    }
}