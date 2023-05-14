class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return -1;
        }
        
        if (grid[0][0] == 1) {
            return -1;
        }
        
        int l = 0;
        
        // 8个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        // 已访问结点
        boolean[][] visited = new boolean[m][n];
        // 源点被访问
        visited[0][0] = true;
        
        // 队列记录结点的坐标(i, j)
        Queue<int[]> qn = new LinkedList<>();
        // 从源点开始
        qn.add(new int[]{0, 0});
        
        // BFS遍历
        while (!qn.isEmpty()) {
            int size = qn.size();
            // 一层一层遍历，一个for循环代表一层
            for (int k = 0; k < size; k++) {
                int[] node = qn.poll();
                int i = node[0];
                int j = node[1];
                if (i == m - 1 && j == n - 1) {
                    qn.clear();
                    break;
                }
                // 遍历与当前结点相邻的结点
                // 8个方向的相邻结点
                for (int dir = 0; dir < dirs.length; dir++) {
                    int ni = i + dirs[dir][0];
                    int nj = j + dirs[dir][1];
                    // 在grid中
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */ && grid[ni][nj] == 0) {
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
            l++;
        }
        
        if (visited[m - 1][n - 1]) {
            return l;
        } else {
            return -1;
        }
    }
}