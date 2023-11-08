class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        if (ss.length != ts.length) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (sMap.containsKey(ss[i])) {
                if (sMap.get(ss[i]) != ts[i]) {
                    return false;
                }
            } else {
                if (tMap.containsKey(ts[i])) {
                    if (tMap.get(ts[i]) != ss[i]) {
                        return false;
                    }
                } else {
                    sMap.put(ss[i], ts[i]);
                    tMap.put(ts[i], ss[i]);
                }
            }
        }
        return true;
    }
}