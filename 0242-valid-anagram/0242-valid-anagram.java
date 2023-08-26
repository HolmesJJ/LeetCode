class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            map.put(sChars[i], map.getOrDefault(sChars[i], 0) + 1);
        }
        for (int i = 0; i < tChars.length; i++) {
            if (map.containsKey(tChars[i]) && map.get(tChars[i]) > 0) {
                map.put(tChars[i], map.get(tChars[i]) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}