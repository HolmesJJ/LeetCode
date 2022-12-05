/**
 * LevelOrder.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file LevelOrder algorithm
 */

export const partialCode = `public levelOrder() {
  
}

// 时间复杂度
O( )

// 空间复杂度
O( )`;

export const fullCode = `public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> levels = new ArrayList<>();
  if (root == null) {
    return levels;
  }

  Queue<TreeNode> qn = new LinkedList<>();
  qn.add(root);

  while (!qn.isEmpty()) {
    int size = qn.size();
    TreeNode node = null;
    // 一层一层遍历, 一个for循环代表一层
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      node = qn.poll();
      level.add(node.val);
      if (node.left != null) {
        qn.add(node.left);
      }
      if (node.right != null) {
        qn.add(node.right);
      }
    }
    levels.add(level);
  }
  return levels;
}

// 时间复杂度
O(E + V)

// 空间复杂度
O(V)`;
