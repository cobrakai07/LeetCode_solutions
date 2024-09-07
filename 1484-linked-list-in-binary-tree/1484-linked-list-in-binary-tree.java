/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    boolean hasList=false;
    public boolean fun(ListNode head, TreeNode root){
        if(head==null)return true;
        if(head==null || root==null)return false;
        if(head.val==root.val){
            return fun(head.next,root.left) || fun(head.next, root.right);
        }else{
            return false;
        }
    }
    public void pre(TreeNode r,ListNode head){
        if(hasList)return;
        if(r!=null){
            hasList=fun(head,r);
            pre(r.left,head);
            pre(r.right,head);
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        pre(root,head);
        return hasList;
    }
}