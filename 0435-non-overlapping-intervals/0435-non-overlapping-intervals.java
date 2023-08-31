class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照区间结尾来排序
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        // 满足条件的所保留的区间
        int count = 1;
        // 记录前一个区间的结尾
        // 只需要记录前一个即可，因为这些区间都已经排好序，前一个区间的结尾就是当前保留的区间的最大值
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 若当前区间的开头大于等于前一个区间的结尾，则说明没有重叠
            if (intervals[i][0] >= pre) {
                count++;
                pre = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}