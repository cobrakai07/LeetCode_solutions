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
class Solution {
    public ListNode fun(ListNode head, ListNode p){
        if(head==null)return p;
        ListNode node=head.next;
        head.next=p;
        return fun(node,head);
    }
    public ListNode reverseList(ListNode head) {
        // if(head==null)return
        return fun(head,null); 
    }
}