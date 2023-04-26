/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int maxSum = INT_MIN;

int gainMaxSum(struct TreeNode* node) {
    if (node == NULL) {
        return 0;
    }
    //Updating the class variable maxSum
    int nodeVal = node->val;
    int leftMax = fmax(gainMaxSum(node->left), 0);
    int rightMax = fmax(gainMaxSum(node->right), 0);
    int nodeMaxPath = nodeVal + leftMax + rightMax;
    maxSum = fmax(maxSum, nodeMaxPath);
    //return the maxvalue that the node can provide for other nodes
    return node->val + fmax(leftMax, rightMax);
    }

int maxPathSum(struct TreeNode* root){
    gainMaxSum(root);
    int res = maxSum;
    maxSum = INT_MIN;
    return res;
}