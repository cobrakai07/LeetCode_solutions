class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int idx=1;
        int min=Integer.MAX_VALUE, max=-1;  
        List<Integer>list=new ArrayList<>();
        while(head!=null){
            if(head.next!=null && head.next.next!=null)
            {
                if((head.val>head.next.val && head.next.val<head.next.next.val) || (head.val<head.next.val && head.next.val>head.next.next.val))
                    list.add(idx);
            }
            head=head.next;
            idx++;
        }

        Collections.sort(list);
        if(list.size()>0)
        {
           for(int i=0;i<list.size()-1;i++){
            min= Math.min(Math.abs(list.get(i)-list.get(i+1)),min);
           }
            
            max= Math.max(Math.abs(list.get(0)-list.get(list.size()-1)),max);
        }

        if(min==Integer.MAX_VALUE)
            return new int[]{-1,-1};      
         return new int[]{min,max};      
    }
}