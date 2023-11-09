class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        for (int i = 0; i < Math.pow(2, k); i++) {
            String value = Integer.toString(i, 2);
            while (value.length() < k) {
                value = "0" + value;
            }
            if (!set.contains(value)) {
                return false;
            }
        }
        return true;
    }
}