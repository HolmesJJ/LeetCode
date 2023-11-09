class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] csubs = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(csubs);
            String subs = String.valueOf(csubs);
            if (map.containsKey(subs)) {
                map.get(subs).add(i);
            } else {
                List<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                map.put(subs, indices);
            }
        }
        char[] ps = p.toCharArray();
        Arrays.sort(ps);
        p = String.valueOf(ps);
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey().equals(p)) {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }
}