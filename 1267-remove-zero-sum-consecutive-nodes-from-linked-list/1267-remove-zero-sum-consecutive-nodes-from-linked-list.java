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

    private boolean fun1( List<ListNode> list )
    {
      for(int i=0;i<list.size();i++)
        {
          if(list.get(i).val==1111)continue;
          int sum=0;
          sum=sum+list.get(i).val;
          for(int j=i+1;j<list.size();j++)
          {
            if(list.get(j).val==1111)continue;
            sum=sum+list.get(j).val;
            if(sum==0)
            {
              fun2(i,j,list);
              return false;
            }
          }
        }

        return true;
    }
    private void fun2(int i,int j, List<ListNode> list )
    {
      for( ;i<=j;i++)
      {
        ListNode temp=list.get(i);
        temp.val=1111;
      }
    }
    public ListNode removeZeroSumSublists(ListNode head) {

        List<ListNode>list= new ArrayList<>();
        for(ListNode i=head;i!=null;i=i.next)
        {
          if(i.val==0)continue;
          list.add(i);
        }
        System.out.println(list.size());

        while(true)
        {
          if(fun1(list))
           break;
        }

        ListNode nhead=null;
        ListNode tail=null;

        for(int i=0;i<list.size();i++)
        {
          if(list.get(i).val==1111)continue;
          if(nhead==null)
          {
            nhead=list.get(i);
            tail=list.get(i);
            tail.next=null;
          }
          else
          {
            tail.next=list.get(i);
            tail=tail.next;
            tail.next=null;
          }
        }

        // for(int i=0;i<list.size();i++)
        // {
        //   System.out.print(list.get(i).val+" ");
        // }
            return nhead;
    }
}