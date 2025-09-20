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
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            // left child
            if (!arr[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(arr[index]));
                node.left = left;
                q.offer(left);
            }
            index++;

            // right child
            if (index < arr.length && !arr[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(arr[index]));
                node.right = right;
                q.offer(right);
            }
            index++;
        }
        return root;
    }
}
