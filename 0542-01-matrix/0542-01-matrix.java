class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dists = new int[m][n];

        if (m == 0 || n == 0) {
            return dists;
        }
        
        // 4个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 已访问结点
        boolean[][] visited = new boolean[m][n];
        
        // 队列记录结点的坐标(i, j)
        Queue<int[]> qn = new LinkedList<>();

        // 找到所有1并加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 其实就是以每个元素0的结点为起点做一次BFS
                if (mat[i][j] == 0) {
                    qn.add(new int[]{i, j});
                    // 结点被访问
                    visited[i][j] = true;
                }
            }
        }
        
        // BFS遍历
        while (!qn.isEmpty()) {
            int[] node = qn.poll();
            int i = node[0];
            int j = node[1];
            // 把当前与结点的相邻的结点都加入到队列
            // 4个方向的相邻结点
            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = i + dirs[dir][0];
                int nj = j + dirs[dir][1];
                // 在mat中
                if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */) {
                    // 排除已经访问过的结点
                    // 把符合条件的结点入队
                    if (visited[ni][nj] == false /* && 其它条件 */) {
                        qn.add(new int[]{ni, nj});
                        // 结点被访问
                        visited[ni][nj] = true;
                        // 若相邻的结点为1, 则更新相邻的结点到最近的0的距离
                        if (mat[ni][nj] == 1) {
                            dists[ni][nj] = dists[i][j] + 1;
                        }
                    }
                }
            }
        }
        return dists;
    }
}