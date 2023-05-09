class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            List<Integer> l = map2.getOrDefault(count, new ArrayList<>());
            l.add(key);
            map2.put(count, l);
        }
        int[] result = new int[nums.length];
        int j = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map2.entrySet()) {
            int count = entry.getKey();
            List<Integer> l = entry.getValue();
            Collections.sort(l, Collections.reverseOrder());
            for (int k = 0; k < l.size(); k++) {
                for (int m = 0; m < count; m++) {
                    result[j] = l.get(k);
                    j++;
                }
            }
        }
        return result;
    }
}