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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leftValues = getLeaves(root1);
        vector<int> rightValues = getLeaves(root2);
        if (leftValues.size() != rightValues.size()) {
            return false;
        }
        for (int i = 0; i < leftValues.size(); i++) {
            if (leftValues[i] != rightValues[i]) {
                return false;
            }
        }
        return true;
    }
    
    vector<int> getLeaves(TreeNode* root) {
        if (root == nullptr) {
            return {};
        }
        vector<int> values = {};
        vector<int> leftValues = getLeaves(root->left);
        for (auto val : leftValues) {
            values.push_back(val);
        }
        if (root->left == nullptr && root->right == nullptr) {
            values.push_back(root->val);
        }
        vector<int> rightValues = getLeaves(root->right);
        for (auto val : rightValues) {
            values.push_back(val);
        }
        return values;
    }
};