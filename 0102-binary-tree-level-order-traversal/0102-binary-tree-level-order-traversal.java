/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> qn = new LinkedList<>();
        qn.add(root);
        while (!qn.isEmpty()) {
            int size = qn.size();
            TreeNode node = null;
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
}