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
    
    private int count = 1;
    private int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }
    
    public void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        if (count < k) {
            count++;
        } else {
            if (result == -1) {
                result = root.val;
            }
            return;
        }
        inOrder(root.right, k);
    }
}