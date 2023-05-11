class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] - b[0] < 0) {
                return -1;
            } else if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            } else {
                return 1;
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (pre[1] < intervals[i][0]) {
                result.add(pre);
                pre = intervals[i];
            } else if (pre[1] >= intervals[i][0] && pre[1] < intervals[i][1]) {
                pre[1] = intervals[i][1];
            }
        }
        result.add(pre);
        return result.toArray(new int[result.size()][2]);
    }
}