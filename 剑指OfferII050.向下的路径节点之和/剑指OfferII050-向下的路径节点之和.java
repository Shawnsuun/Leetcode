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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);  //path started from root

        return dfs(root, targetSum, map, 0);
    }

    private int dfs(TreeNode root, int tar, Map<Long, Integer> map, long path) {
        if (root == null) return 0;
        
        //pre-order traverse
        path += root.val;
        int count = map.getOrDefault(path - tar, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        count += dfs(root.left, tar, map, path);
        count += dfs(root.right, tar, map, path);
        
        //backtracking
        map.put(path, map.get(path) - 1);
        return count;
    } 
}