class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();

        int count=0;
        for(int i: nums)
        {
            if(i<k)count++;
            pq.offer((long)i);
        }
        // System.out.println(count);
        int op=0;
        if(count==0)return op;
        while(pq.size()>=2)
        {
            // System.out.println(pq);
            if(count==0)return op;
            long x=pq.poll();
            long y=pq.poll();
            
            long newVal=Math.min(x, y) * 2 + Math.max(x, y);
            if(newVal<k)
            {
                if(x<k)count--;if(y<k)count--;
                count++;
                pq.offer(newVal);
            }
            else
            {
                if(x<k)count--;if(y<k)count--;
                pq.offer(newVal);
            }
          
            op++;
           
            
        }
           
        return op;
            
    }
}
