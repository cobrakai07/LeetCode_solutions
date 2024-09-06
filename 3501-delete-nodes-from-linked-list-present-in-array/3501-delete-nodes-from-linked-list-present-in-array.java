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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode nHead=null;
        ListNode nTail=null;
        List<ListNode>list=new ArrayList<>();
        Set<Integer>s=new HashSet<>();

        for(int i: nums)s.add(i);

        while(head!=null)
        {
            if(!s.contains(head.val))
                list.add(new ListNode(head.val));
            head=head.next;
        }

        for(ListNode l: list){
            if(nHead==null){
                nHead=l;
                nTail=l;
            }else{
                nTail.next=l;
                l.next=null;
                nTail=nTail.next;
            }
        }
        return nHead;
    }
}