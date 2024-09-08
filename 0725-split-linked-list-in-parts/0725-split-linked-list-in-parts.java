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
 /////////////used hint to solve this///////////////////// 
class Solution {

    public ListNode cListF(ArrayList<Integer> al)
    {
        ListNode hlist=null;
        ListNode tlist=null;
        for(int i=0;i<al.size();i++)
        {
            if(hlist==null&&tlist==null)
            {
                hlist=new ListNode(al.get(i));
                tlist=hlist;
            } 
            else
            {
                tlist.next= new ListNode(al.get(i));
                tlist=tlist.next;
            }
        }
        return hlist;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
       ListNode c=head;
       int count=0;
       while(c!=null)
       {
           count++;
           c=c.next;
       } 
       ListNode[] ans=new ListNode[k];
       int extraOne=count%k;
       int len=count/k;
       int length=len+1;
       int idx=0;
       for(int i=0;i<extraOne;i++)
       {
           ArrayList<Integer> temp=new ArrayList<>();
           int temp1=length;
           while((length)!=0)
           {
              temp.add(head.val);
              head=head.next; 
              length--;
           }
           ans[idx++]=cListF(temp);
           length=temp1;
       }
       int remparts=k-extraOne;
       for(int i=0;i<remparts;i++)
       {
           ArrayList<Integer> temp=new ArrayList<>();
           int temp1=len;
           while((len)!=0)
           {
              temp.add(head.val);
              head=head.next; 
              len--;
           }
           ans[idx++]=cListF(temp);
           len=temp1;
       }
      return ans;
    }
}