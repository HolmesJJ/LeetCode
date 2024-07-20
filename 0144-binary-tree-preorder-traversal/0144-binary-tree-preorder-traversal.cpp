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
    vector<int> preorderTraversal(TreeNode* root) {
        if (root == nullptr) {
            return {};
        }
        vector<int> values = {};
        values.push_back(root->val);
        vector<int> leftValues = preorderTraversal(root->left);
        for (auto val : leftValues) {
            values.push_back(val);
        }
        vector<int> rightValues = preorderTraversal(root->right);
        for (auto val : rightValues) {
            values.push_back(val);
        }
        return values;
    }
};