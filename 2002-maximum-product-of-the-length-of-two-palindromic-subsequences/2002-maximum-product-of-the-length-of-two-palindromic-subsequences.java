class Solution {
    public int maxProduct(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            String subSeq = "";
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subSeq = subSeq + cs[i];
                }
            }
            if (subSeq.equals(new StringBuilder(subSeq).reverse().toString())) {
                map.put(mask, subSeq.length());
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                if ((entry1.getKey() & entry2.getKey()) == 0) {
                    res = Math.max(res, entry1.getValue() * entry2.getValue());
                }
            }
        }
        return res;
    }
}