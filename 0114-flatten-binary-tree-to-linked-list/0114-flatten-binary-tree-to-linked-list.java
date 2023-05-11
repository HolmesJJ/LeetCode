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
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = preOrder(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
    }
    
    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        nodes.add(root);
        nodes.addAll(preOrder(root.left));
        nodes.addAll(preOrder(root.right));
        return nodes;
    }
}