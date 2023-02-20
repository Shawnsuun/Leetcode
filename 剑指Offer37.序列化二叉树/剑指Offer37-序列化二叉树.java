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
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode polled = queue.poll();
            if (polled == null) {
                builder.append("null");
            } else {
                builder.append(polled.val);
            }
            builder.append(',');
            if (polled != null) {
                queue.offer(polled.left);
                queue.offer(polled.right); 
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();  //1,2,3,null,null,4,5,null,null,null,null
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (!strs[index].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(node.left);
            } else {
                node.left = null;
            }
            index ++;
            if (!strs[index].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(node.right);
            } else {
                node.right = null;
            }
            index ++;           
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));