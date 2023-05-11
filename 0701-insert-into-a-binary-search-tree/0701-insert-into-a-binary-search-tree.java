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
    
    TreeNode pre = null;
    TreeNode node = null;
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        inOrder(root, val);
        if (pre == null) {
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
            }
            node.left = new TreeNode(val);
        } else if (pre.right == null) {
            pre.right = new TreeNode(val);
        } else {
            TreeNode node = pre.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = new TreeNode(val);
        }
        return root;
    }
    
    public void inOrder(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        inOrder(root.left, val);
        if (root.val < val) {
            pre = root;
        } else {
            return;
        }
        inOrder(root.right, val);
    }
}