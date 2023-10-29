/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public void fun(final TreeNode r, final TreeNode t)
    {
        if(r!=null)
        {
            if(r.val==t.val)
            {
                if(((r.left!=null&&r.left.val==t.left.val)||(r.left==null&&t.left==null))&&((r.right!=null&&r.right.val==t.right.val)||(r.right==null&&t.right==null)))
                ans=r;
            }
            fun(r.left,t);
            fun(r.right,t);
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        fun(cloned,target);
        return ans;
    }
}