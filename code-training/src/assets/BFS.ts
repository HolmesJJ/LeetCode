/**
 * BFS.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file BFS algorithm
 */

export const partialCode = `public bfs() {
  /* && 是否相邻 */
  /* && 其它条件 */
}

// 时间复杂度
O( )

// 空间复杂度
O( )`;

export const fullCode = `public void bfs(char[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  if (m == 0 || n == 0) {
    return;
  }
  
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  
  boolean[][] visited = new boolean[m][n];
  visited[0][0] = true;
  
  Queue<int[]> qn = new LinkedList<>();
  qn.add(new int[]{0, 0});
  
  while (!qn.isEmpty()) {
    int[] node = qn.poll();
    int i = node[0];
    int j = node[1];
    for (int dir = 0; dir < dirs.length; dir++) {
      int ni = i + dirs[dir][0];
      int nj = j + dirs[dir][1];
      if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */) {
        if (visited[ni][nj] == false /* && 其它条件 */) {
          qn.add(new int[]{ni, nj});
          visited[ni][nj] = true;
        }
      }
    }
  }
}

// 时间复杂度
O(E + V)

// 空间复杂度
O(V)`;
