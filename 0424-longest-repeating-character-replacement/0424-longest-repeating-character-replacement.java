class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        char maxChar = sChars[0];
        int maxLen = 0;
        while (right < sChars.length) {
            map.put(sChars[right], map.getOrDefault(sChars[right], 0) + 1);
            if (sChars[right] != maxChar && map.get(sChars[right]) > map.get(maxChar)) {
                maxChar = sChars[right];
            }
            int windowSize = right - left + 1;
            maxCount = windowSize - map.get(maxChar);
            while (maxCount > k) {
                map.put(sChars[left], map.get(sChars[left]) - 1);
                for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                    if (entry.getValue() > map.get(maxChar)) {
                        maxChar = entry.getKey();
                    }
                }
                left++;
                windowSize = right - left + 1;
                maxCount = windowSize - map.get(maxChar);
            }
            maxLen = Math.max(maxLen, windowSize);
            right++;
        }
        return maxLen;
    }
}