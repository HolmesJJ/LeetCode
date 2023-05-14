class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // 4个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 已访问结点
        boolean[][] visited = new boolean[m][n];
        
        // 队列记录结点的坐标(i, j)
        Queue<int[]> qn = new LinkedList<>();
        
        // 找到所有烂橘子并加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    qn.add(new int[]{i, j});
                    // 结点被访问
                    visited[i][j] = true;
                }
            }
        }
        
        int mins = -1;
        
        // BFS遍历
        while (!qn.isEmpty()) {
            int size = qn.size();
            // 一层一层遍历，一个for循环代表一层
            for (int k = 0; k < size; k++) {
                int[] node = qn.poll();
                int i = node[0];
                int j = node[1];
                // 把当前与结点的相邻的结点都加入到队列
                // 4个方向的相邻结点
                for (int dir = 0; dir < dirs.length; dir++) {
                    int ni = i + dirs[dir][0];
                    int nj = j + dirs[dir][1];
                    // 在grid中
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                        qn.add(new int[]{ni, nj});
                        // 结点被访问
                        visited[ni][nj] = true;
                        grid[ni][nj] = 2;
                    }
                }
            }
            mins++;
        }
        
        // 检查是否还有好橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        // 好坏橘子都没有
        if (mins == -1) {
            return 0;
        }
        
        return mins;
    }
}