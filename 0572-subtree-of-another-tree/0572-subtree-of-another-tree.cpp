/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if (root == nullptr || subRoot == nullptr) {
            return false;
        }
        bool mid = isEqual(root, subRoot);
        if (mid) {
            return true;
        }
        bool left = isEqual(root->left, subRoot);
        if (left) {
            return true;
        }
        bool right = isEqual(root->right, subRoot);
        if (right) {
            return true;
        }
        bool l = isSubtree(root->left, subRoot);
        bool r = isSubtree(root->right, subRoot);
        return l || r;
    }

    bool isEqual(TreeNode* node1, TreeNode* node2) {
        if (node1 == nullptr && node2 == nullptr) {
            return true;
        }
        if (node1 == nullptr || node2 == nullptr) {
            return false;
        }
        if (node1->val != node2->val) {
            return false;
        }
        bool left = isEqual(node1->left, node2->left);
        bool right = isEqual(node1->right, node2->right);
        return left && right;
    }
};