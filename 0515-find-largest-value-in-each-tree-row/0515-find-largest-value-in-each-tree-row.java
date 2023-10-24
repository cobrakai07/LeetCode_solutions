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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        Queue<TreeNode> q= new ArrayDeque<>();
        if(root==null)return list;
        TreeNode newLine=new TreeNode(Integer.MIN_VALUE,null,null);
        q.offer(root);q.offer(newLine);
        while(!q.isEmpty())
        {
           TreeNode p=q.poll();
            if(p.equals(newLine))
            {
                list.add(max);
                max=Integer.MIN_VALUE;
                if(q.isEmpty())break;
                q.offer(newLine);

            }
            else
            {
                if(max<p.val)max=p.val;
                if(p.left!=null)q.offer(p.left);
                if(p.right!=null)q.offer(p.right);

            }
        }
        return list;
    }
}