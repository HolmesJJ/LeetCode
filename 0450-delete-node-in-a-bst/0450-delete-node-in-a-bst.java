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

    TreeNode parent = null;
    TreeNode node = null;
    
    public TreeNode deleteNode(TreeNode root, int key) {
        inOrder(root, key);
        if (node == null) {
            return root;
        }
        // 把当前节点node向右移动一次, 然后连续向左移动, 直到最后, 最后的节点next为当前节点node的下一个节点
        // 把当前节点node的左子树连接到next的左边
        if (node.right == null) {
            // 若parent不存在, 又没有右节点, 代表删除的节点就是root节点且只有左子树
            if (parent == null) {
                root = root.left;
            }
            // 若parent存在, 直接把parent和next连接
            else {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        } else {
            TreeNode tmp = node.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = node.left;
            // 若parent不存在, 代表删除的节点就是root节点
            if (parent == null) {
                root = root.right;
            }
            // 若parent存在, 直接把parent和node右子树连接
            else {
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        }
        return root;
    }

    public void inOrder(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        inOrder(root.left, key);
        if (root.left != null && root.left.val == key) {
            parent = root;
        }
        if (root.right != null && root.right.val == key) {
            parent = root;
        }
        if (root.val == key && node == null) {
            node = root;
        }
        inOrder(root.right, key);
    }
}