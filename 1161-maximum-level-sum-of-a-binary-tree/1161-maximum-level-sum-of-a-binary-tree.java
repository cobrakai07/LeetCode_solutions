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
    public int maxLevelSum(TreeNode root) {
        long maxSum = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        int currLevel = 1;
        Queue<TreeNode> q= new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            long currSum = 0;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                currSum += node.val;
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            if(currSum>maxSum){
                // System.out.println("kk");
                maxSum = currSum;
                minLevel = currLevel;
            }
            currLevel++;
        }
        return minLevel;
    }
}