class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> topList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, (a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (q.size() < k) {
                q.add(entry);
            } else {
                if (q.peek().getValue() < entry.getValue()) {
                    q.poll();
                    q.add(entry);
                }
            }
        }
        int j = 0;
        int[] topArr = new int[q.size()];
        while (q.size() > 0) {
            Map.Entry<Integer, Integer> entry = q.poll();
            topArr[j] = entry.getKey();
            j++;
        }
        return topArr;
    }
}