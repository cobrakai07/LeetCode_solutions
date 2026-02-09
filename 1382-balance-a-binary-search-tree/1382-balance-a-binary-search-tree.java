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
    public void inOrder(TreeNode root,List<TreeNode> list){
        if(root!=null){
            inOrder(root.left, list);
            list.add(root);
            inOrder(root.right,list);
        }
    }
    public TreeNode balanceTree(int left, int right,List<TreeNode> list){
        if(left>right)return null;
        int mid = left+(right-left)/2;
        TreeNode root = list.get(mid);
        root.left = balanceTree(left,mid-1,list);
        root.right = balanceTree(mid+1,right,list);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inOrderList = new ArrayList<>();
        inOrder(root,inOrderList);
        return balanceTree(0,inOrderList.size()-1,inOrderList);
    }
}