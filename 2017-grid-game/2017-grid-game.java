class Solution {
    public long gridGame(int[][] grid) {
        long[] prefixSums = new long[grid[0].length];
        prefixSums[0] = grid[0][0];
        long[] postfixSums = new long[grid[0].length];
        postfixSums[postfixSums.length - 1] = grid[1][grid[0].length - 1];
        for (int i = 1; i < grid[0].length; i++) {
            prefixSums[i] = prefixSums[i - 1] + grid[0][i];
        }
        for (int i = grid[0].length - 2; i >= 0; i--) {
            postfixSums[i] = postfixSums[i + 1] + grid[1][i];
        }
        int index = 0;
        long minBot2 = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            long sumBot2 = Math.max(prefixSums[prefixSums.length - 1] - prefixSums[i],
                                    postfixSums[0] - postfixSums[i]);
            if (minBot2 > sumBot2) {
                minBot2 = sumBot2;
                index = i;
            }
        }
        return minBot2;
    }
}