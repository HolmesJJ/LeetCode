class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        String str = "";
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int pos = map.get(chars[i]);
                if (start <= pos) {
                    start = pos + 1;
                }
                str = str + chars[i];
                map.put(chars[i], str.length() - 1);
            } else {
                str = str + chars[i];
                map.put(chars[i], str.length() - 1);
            }
            maxLength = Math.max(maxLength, str.length() - start);
        }
        return maxLength;
    }
}