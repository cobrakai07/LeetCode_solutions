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
    static int findGCD(int a, int b)   
     {   
     if (b == 0)   
       return a;     
     return findGCD(b, a % b);   
    }   
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ArrayList<ListNode>list= new ArrayList<>();
        ListNode p=head;
        while(p!=null)
        {
            list.add(p);
            p=p.next;
        }
        if(list.size()==1)return head;
        int ptr1=0;
        int ptr2=ptr1+1;
        ArrayList<ListNode>gcd=new ArrayList<>();
        while(ptr2<list.size())
        {
            int t=findGCD(list.get(ptr1).val,list.get(ptr2).val);
            ListNode temp= new ListNode(t,null);
            gcd.add(temp);
            ptr1++;ptr2++;
        }
        
        int pointer1=0;
        int pointer2=1;
        
        int gcdpointer=0;
        
        while(pointer2<list.size())
        {
            ListNode one=list.get(pointer1);
            ListNode two=gcd.get(gcdpointer);
            ListNode three=list.get(pointer2);
            
            one.next=two;
            two.next=three;
            three.next=null;
            
            pointer1++;
            pointer2++;
            gcdpointer++;
        }
        
        return list.get(0);
        
        
    }
}