class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Set<Integer> searchedSet = new HashSet<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (searchedSet.contains(nums[i])) {
                System.out.println(nums[i]);
                continue;
            }
            int upCount = 0;
            int downCount = 0;
            int num = nums[i];
            while (set.contains(num)) {
                searchedSet.add(num);
                upCount++;
                num++;
            }
            num = nums[i] - 1;
            while (set.contains(num)) {
                searchedSet.add(num);
                downCount++;
                num--;
            }
            maxCount = Math.max(maxCount, upCount + downCount);
        }
        return maxCount;
    }
}