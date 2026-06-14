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
    public ListNode rev(ListNode head, ListNode pre){
        if(head.next == null){
            head.next = pre;
            return head;
        }
        ListNode next = head.next;
        head.next = pre;
        return rev(next,head);
    }
   
    public int pairSum(ListNode head) {
        ListNode nhead = head;
        int len =0;
        while(nhead!=null){
            len++;
            nhead = nhead.next;
        }
        nhead = null;
        ListNode temp = head;
        int length = len/2;
        while(length!=1){
            length--;
            temp = temp.next;
        }
        nhead = temp.next;
        temp.next = null;

        nhead = rev(nhead,null);
        
        int max = 0;
     
        while(head!=null){
            max = Math.max(head.val+nhead.val,max);
            head = head.next;
            nhead = nhead.next;
        }

        return max;
        


    }
}