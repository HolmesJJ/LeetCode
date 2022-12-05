/**
 * Backtracking.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Backtracking algorithm
 */

export const partialCode = `// results是最终结果

// result是其中一个结果


public backtracking( /* 其它条件和参数 */) {
  /* 终止条件 */
  /* 集合元素 */
  /* 其它条件和参数 */
}

// 时间复杂度
// Hamiltonian Cycle: O( )
// WordBreak and StringSegment: O( )
// NQueens: O( )

// 空间复杂度
O( )`;

export const fullCode = `// results是最终结果
List<List<Integer>> results = new ArrayList<>();
// result是其中一个结果
List<Integer> result = new ArrayList<>();
backtracking(results, result);

public void backtracking(List<List<Integer>> results, List<Integer> result /* 其它条件和参数 */) {
  if (/* 终止条件 */) {
    results.add(new ArrayList<>(result));
    return;
  }
  for (/* 集合元素 */) {
    result.add();
    backtracking(results, result /* 其它条件和参数 */);
    result.remove(result.size() - 1);
  }
}

// 时间复杂度
// Hamiltonian Cycle: O(n!)
// WordBreak and StringSegment: O(2^n)
// NQueens: O(n!)

// 空间复杂度
O(n)`;
