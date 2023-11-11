class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> line = wall.get(i);
            int prefixSum = 0;
            for (int j = 0; j < line.size() - 1; j++) {
                prefixSum = prefixSum + line.get(j);
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            }
        }
        int gaps = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            gaps = Math.max(gaps, entry.getValue());
        }
        return wall.size() - gaps;
    }
}