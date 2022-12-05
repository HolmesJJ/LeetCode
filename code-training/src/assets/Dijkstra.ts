/**
 * Dijkstra.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Dijkstra algorithm
 */

export const partialCode = `public dijkstra() {
  /* && 是否相邻 */
  /* && 其它条件 */
}

// 时间复杂度
O( )

// 空间复杂度
O( )`;

export const fullCode = `public void dijkstra(char[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  if (m == 0 || n == 0) {
    return;
  }
  
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  
  int[][] dists = new int[m][n];
  for (int i = 0; i < dists.length; i++) {
    Arrays.fill(dists[i], Integer.MAX_VALUE);
  }
  dists[0][0] = 1;
  
  int[][][] parents = new int[m][n][2];
  
  boolean[][] visited = new boolean[m][n];
  visited[0][0] = true;
  
  Queue<int[]> qn = new LinkedList<>();
  qn.add(new int[]{0, 0});
  
  while (!qn.isEmpty()) {
    int[] node = qn.poll();
    int i = node[0];
    int j = node[1];
    visited[i][j] = true;
    for (int dir = 0; dir < dirs.length; dir++) {
      int ni = i + dirs[dir][0];
      int nj = j + dirs[dir][1];
      if (ni >= 0 && ni < m && nj >= 0 && nj < n /* && 是否相邻 */) {
        if (visited[ni][nj] == false && dists[ni][nj] > dists[i][j] + 1 /* && 其它条件 */) {
          qn.add(new int[]{ni, nj});
          parents[ni][nj] = new int[]{i, j};
          dists[ni][nj] = dists[i][j] + 1;
        }
      }
    }
  }
  
  Stack<int[]> sn = new Stack<>();
  sn.add(new int[]{m - 1, n - 1});
  int[] parent = parents[m - 1][n - 1];
  sn.add(parent);
  while (parent[0] != 0 || parent[1] != 0) {
    parent = parents[parent[0]][parent[1]];
    sn.add(parent);
  }
  System.out.println("The shortest distance is " + dists[m - 1][n - 1]);
  while (!sn.isEmpty()) {
    int[] node = sn.pop();
    int i = node[0];
    int j = node[1];
    if (sn.isEmpty()) {
      System.out.print("(" + i + ", " + j + ")");
    } else {
      System.out.print("(" + i + ", " + j + "), ");
    }
  }
}

// 时间复杂度
O(E + VlogV)

// 空间复杂度
O(V)`;
