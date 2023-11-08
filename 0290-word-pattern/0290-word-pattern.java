class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        char[] ps = pattern.toCharArray();
        String[] ss = s.split(" ");
        if (ps.length != ss.length) {
            return false;
        }
        for (int i = 0; i < ps.length; i++) {
            if (pMap.containsKey(ps[i])) {
                if (!pMap.get(ps[i]).equals(ss[i])) {
                    return false;
                }
            } else {
                if (sMap.containsKey(ss[i])) {
                    if (sMap.get(ss[i]) != ps[i]) {
                        return false;
                    }
                } else {
                    pMap.put(ps[i], ss[i]);
                    sMap.put(ss[i], ps[i]);
                }
            }
        }
        return true;
    }
}