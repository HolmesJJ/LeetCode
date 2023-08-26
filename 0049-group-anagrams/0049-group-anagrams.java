class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            List<String> group = map.getOrDefault(str, new ArrayList<>());
            group.add(strs[i]);
            map.put(str, group);
        }
        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }
}