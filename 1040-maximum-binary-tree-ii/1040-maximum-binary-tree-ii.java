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
    public TreeNode fun(int i, int j, List<Integer>nums){
        
        if(i==j)return new TreeNode(nums.get(i));
        if(i>j)return null;

        int max=Integer.MIN_VALUE;
        int maxIdx=-1;

        for(int it=i; it<=j; it++){
            if(max<nums.get(it)){
                max=nums.get(it);
                maxIdx=it;
            }
        }
        TreeNode t = new TreeNode(max);
        t.left= fun(i,maxIdx-1, nums);
        t.right= fun(maxIdx+1, j, nums);

        return t;
    }
    public void pre(TreeNode r, List<Integer>list){
        if(r!=null){
            pre(r.left,list);
            list.add(r.val);
            pre(r.right,list);
        }
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer>list=new ArrayList<>();
        pre(root, list);
        list.add(val);
        return fun(0,list.size()-1,list);
    }
}