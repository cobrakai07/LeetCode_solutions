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
    public int getDecimalValue(ListNode head) {
        int count = -1;
        ListNode node = head;
        while(node!=null){
            count++;
            node=node.next;
        }
        int num=0;
        while(head!=null){
            if(head.val==1){
                num = num + (int)Math.pow(2,count);
            }
            head=head.next;
            count--;
        }
        return num;
    }
}