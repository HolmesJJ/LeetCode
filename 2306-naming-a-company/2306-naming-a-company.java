class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < ideas.length; i++) {
            String key = ideas[i].substring(0, 1);
            String value = ideas[i].substring(1, ideas[i].length());
            if (!map.containsKey(key)) {
                Set<String> values = new HashSet<>();
                values.add(value);
                map.put(key, values);
            } else {
                map.get(key).add(value);
            }
        }
        long res = 0;
        for (Map.Entry<String, Set<String>> entry1 : map.entrySet()) {
            for (Map.Entry<String, Set<String>> entry2 : map.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    continue;
                }
                long intersect = 0;
                Set<String> ws1 = entry1.getValue();
                Set<String> ws2 = entry2.getValue();
                for (String w1 : ws1) {
                    if (ws2.contains(w1)) {
                        intersect++;
                    }
                }
                long distinct1 = ws1.size() - intersect;
                long distinct2 = ws2.size() - intersect;
                res += distinct1 * distinct2;
            }
        }
        return res;
    }
}