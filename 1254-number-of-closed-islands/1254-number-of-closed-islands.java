class Solution {
    
    private int count = 0;
    
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return count;
        }
        
         // 已访问结点
        boolean[][] visited = new boolean[m][n];
        
        // 找到所有不靠边的0并加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && i < m - 1 && j > 0 && j < n - 1 && grid[i][j] == 0 && visited[i][j] == false) {
                    visited = bfs(grid, visited, new int[]{i, j});
                }
            }
        }
        
        return count;
    }
    
    public boolean[][] bfs(int[][] grid, boolean[][] visited, int[] source) {
        boolean isClosed = true;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // 4个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 队列记录结点的坐标(i, j)
        Queue<int[]> qn = new LinkedList<>();
        // 从源点开始
        qn.add(source);
        
        // BFS遍历
        while (!qn.isEmpty()) {
            int[] node = qn.poll();
            int i = node[0];
            int j = node[1];
            // 遍历与当前结点相邻的结点
            // 4个方向的相邻结点
            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = i + dirs[dir][0];
                int nj = j + dirs[dir][1];
                // 在grid中
                if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */ && grid[ni][nj] == 0) {
                    if (ni == 0 || ni == m - 1 || nj == 0 || nj == n - 1) {
                        isClosed = false;
                    }
                    // 排除已经访问过的结点
                    // 把符合条件的结点入队
                    if (visited[ni][nj] == false /* && 其它条件 */) {
                        qn.add(new int[]{ni, nj});
                        // 结点被访问
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        
        if (isClosed) {
            count++;
        }
        
        return visited;
    }
}