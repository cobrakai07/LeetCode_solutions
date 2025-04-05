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
    public int dfs (TreeNode r, HashMap<Integer, TreeNode> map){
        if(r==null)return 0;
        if(r.left==null && r.right==null && map.containsKey(r.val))return 1;
        int left = dfs(r.left,map);
        int right = dfs(r.right,map);
        return left+right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<TreeNode>> bfs = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode t = q.poll();
                list.add(t);
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
            }
            bfs.add(list);
        }

        HashMap<Integer, TreeNode> map = new HashMap<>();
        List<TreeNode> list = bfs.get(bfs.size() - 1);
        for (TreeNode t : list) {
            map.put(t.val, t);
        }

        if(map.size()==1)return bfs.get(bfs.size() - 1).get(0);

        for (int i = bfs.size() - 2; i >= 0; i--) {
            List<TreeNode> list1 = bfs.get(i);
            for (TreeNode t : list1) {
               if(dfs(t,map)==map.size())return t;
            }
        }
        return root;

    }
}