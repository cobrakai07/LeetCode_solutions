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
record Node(TreeNode node, int time){}
class Solution {
    TreeNode target;
    public void fun(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode>mp, int start){
        if(root== null)return;
        if(root.val==start)
            target=root;
        mp.put(root,parent);
        fun(root.left,root,mp,start);
        fun(root.right,root,mp,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode>mp = new HashMap<>();
        fun(root,null,mp,start);
        
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(target,0));
        Set<Integer> set = new HashSet<>();
        int time = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            set.add(node.node().val);

            time = Math.max(time,node.time());

            if(node.node().left!=null && !set.contains(node.node().left.val))
                q.offer(new Node(node.node().left, node.time()+1));
            if(node.node().right!=null && !set.contains(node.node().right.val))
                q.offer(new Node(node.node().right, node.time()+1));
            if(mp.get(node.node())!=null){
                TreeNode par = mp.get(node.node());
                if(!set.contains(par.val))
                q.offer(new Node(par, node.time()+1));
            }

        }
        
        return time;

    }
}