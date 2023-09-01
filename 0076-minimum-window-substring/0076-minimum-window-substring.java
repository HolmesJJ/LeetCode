class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }
        int left = 0;
        int right = 0;
        int windowSize = 0;
        int start = 0;
        int minWindowSize = Integer.MAX_VALUE;
        while (left < sChars.length && !tMap.containsKey(sChars[left])) {
            left++;
        }
        right = left;
        while (right < sChars.length) {
            if (tMap.containsKey(sChars[right])) {
                sMap.put(sChars[right], sMap.getOrDefault(sChars[right], 0) + 1);
                boolean moving = true;
                while (moving) {
                    boolean moveLeft = false;
                    for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
                        if (entry.getValue() > tMap.get(entry.getKey()) && sChars[left] == entry.getKey()) {
                            moveLeft = true;
                            break;
                        }
                    }
                    if (moveLeft) {
                        sMap.put(sChars[left], sMap.get(sChars[left]) - 1);
                        left++;
                        while (!tMap.containsKey(sChars[left])) {
                            left++;
                        }
                    } else {
                        moving = false;
                    }
                }
                boolean isValid = true;
                for (Map.Entry<Character, Integer> entry: tMap.entrySet()) {
                    if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) < entry.getValue()) {
                        isValid = false;
                    }
                }
                windowSize = right - left + 1;
                if (isValid && windowSize < minWindowSize) {
                    System.out.println(s.substring(left, left + windowSize));
                    start = left;
                    minWindowSize = windowSize;
                }
            }
            right++;
        }
        for (int i = 0; i < tChars.length; i++) {
            if (!sMap.containsKey(tChars[i])) {
                return "";
            }
        }
        for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
            if (entry.getValue() < tMap.get(entry.getKey())) {
                return "";
            }
        }
        return s.substring(start, start + minWindowSize);
    }
}