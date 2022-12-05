/**
 * BreakInNestedLoops.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file BreakInNestedLoops algorithm
 */

export const partialCode = `
for (int i = 0; i < m; i++) {
  for (int j = 0; j < n; j++) {
    if (grid[i][j] == 1) {
      // 直接跳出两层循环
    }
  }
}`;

export const fullCode = `stop:
for (int i = 0; i < m; i++) {
  for (int j = 0; j < n; j++) {
    if (grid[i][j] == 1) {
      // 直接跳出两层循环
      break stop;
    }
  }
}`;
