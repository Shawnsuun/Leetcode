/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int[] index = {0};
        return dfs(strs, index);
    }

    private TreeNode dfs(String[] strs, int[] index) {
        if (strs[index[0]].equals("null")) {
            index[0] ++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[index[0]]));
        index[0] ++;
        node.left = dfs(strs, index);
        node.right = dfs(strs, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));










