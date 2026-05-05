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
    public int length(ListNode head){
        ListNode node = head;
        int len = 0;
        while(node!=null){
            len++;
            node = node.next ;
        }
        return len;
    }

    public ListNode makeParts(ListNode head, int len){
        ListNode temp = head;
        ListNode nhead = null;
        while(len!=0){
            len--;
            if(len==1){
                nhead = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        temp = nhead;
        while(temp!= null && temp.next!=null){
            temp = temp.next;
        }

        temp.next = head;
        return nhead;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null)return head;
        int len = length(head);
        k = k%len;
        if(k==0)return head;
        // System.out.println(k);
        return makeParts(head,len-k+1);

    }
}