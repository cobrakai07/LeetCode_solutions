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
    int total = 0;
    public int sum(int n, TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null){
             if(root.val==1){
            n = 1|(n<<1);
        }else{
            n = n<<1;
        }
            // System.out.println(Integer.toBinaryString(n));
            total += n;
            return 0;
        }

        if(root.val==1){
            n = 1|(n<<1);
        }else{
            n = n<<1;
        }

        int left = 0, right =0;
// System.out.println(Integer.toBinaryString(n)+" ....");
        left =  sum(n, root.left);
        right = sum(n, root.right);

        return left+right;
    }

    public int sumRootToLeaf(TreeNode root) {
        int rand = sum(0, root);
        return total;
    }
}