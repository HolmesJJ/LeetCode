/**
 * DFS.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file DFS algorithm
 */

export const partialCode = `public dfs() {
  /* && 是否相邻 */
  /* && 其它条件 */
}

// 时间复杂度
O( )

// 空间复杂度
O( )`;

export const fullCode = `public void dfs(char[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  if (m == 0 || n == 0) {
    return;
  }
  
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  
  boolean[][] visited = new boolean[m][n];
  visited[0][0] = true;
  
  Stack<int[]> sn = new Stack<>();
  sn.add(new int[]{0, 0});
  
  while (!sn.isEmpty()) {
    int[] node = sn.peek();
    int i = node[0];
    int j = node[1];
    boolean isAllVisited = true;
    for (int dir = 0; dir < dirs.length; dir++) {
      int ni = i + dirs[dir][0];
      int nj = j + dirs[dir][1];
      if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */) {
        if (visited[ni][nj] == false /* && 其它条件 */) {
          isAllVisited = false;
          sn.add(new int[]{ni, nj});
          visited[ni][nj] = true;
          break;
        }
      }
    }
    if (isAllVisited) {
      sn.pop();
    }
  }
}

// 时间复杂度
O(E + V)

// 空间复杂度
O(V)`;
