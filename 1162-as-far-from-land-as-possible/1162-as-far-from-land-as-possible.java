class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return -1;
        }
        
        int[][] dists = new int[m][n];
        
        // 4个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 已访问结点
        boolean[][] visited = new boolean[m][n];
        
        // 队列记录结点的坐标(i, j)
        Queue<int[]> qn = new LinkedList<>();
        
        // 找到所有1并加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    qn.add(new int[]{i, j});
                    // 结点被访问
                    visited[i][j] = true;
                }
            }
        }
        
        if (qn.size() == 0 || qn.size() == m * n) {
            return -1;
        }
        
        // BFS遍历
        while (!qn.isEmpty()) {
            int[] node = qn.poll();
            int i = node[0];
            int j = node[1];
            // 遍历与当前结点相邻的结点
            // 8个方向的相邻结点
            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = i + dirs[dir][0];
                int nj = j + dirs[dir][1];
                // 在grid中
                if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */) {
                    // 排除已经访问过的结点
                    // 把符合条件的结点入队
                    if (visited[ni][nj] == false /* && 其它条件 */) {
                        qn.add(new int[]{ni, nj});
                        // 结点被访问
                        visited[ni][nj] = true;
                        if (dists[ni][nj] == 0) {
                            dists[ni][nj] = dists[i][j] + 1;
                        }
                    }
                }
            }
        }
        
        int maxDist = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxDist = Math.max(maxDist, dists[i][j]);
            }
        }
        
        return maxDist;
    }
}