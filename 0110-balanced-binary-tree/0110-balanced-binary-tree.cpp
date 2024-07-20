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
    bool result = true; 
    
    bool isBalanced(TreeNode* root) {
        getMaxDeepth(root);
        return result;
    }

    int getMaxDeepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int l = getMaxDeepth(root->left);
        int r = getMaxDeepth(root->right);
        if (abs(l - r) > 1) {
            result = false;
        }
        return 1 + max(l, r);
    }
};