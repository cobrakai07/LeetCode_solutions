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
    public TreeNode fun(int i, int j, int []nums){
        
        if(i==j)return new TreeNode(nums[i]);
        if(i>j)return null;

        int max=Integer.MIN_VALUE;
        int maxIdx=-1;

        for(int it=i; it<=j; it++){
            if(max<nums[it]){
                max=nums[it];
                maxIdx=it;
            }
        }
        TreeNode t = new TreeNode(max);
        t.left= fun(i,maxIdx-1, nums);
        t.right= fun(maxIdx+1, j, nums);

        return t;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return fun(0, nums.length-1, nums);
        
    }
}