class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Float>pq=new PriorityQueue<>();
        for(int i=0;i<dist.length;i++)
        {
            pq.add((float)dist[i]/(float)speed[i]);
        }
       // System.out.println(pq);
        float first=pq.poll();
        if(first<=0)return 0;
        int count=1;
        int timeSpent=1;
        while(!pq.isEmpty())
        {
            float temp=pq.poll()-timeSpent;
            timeSpent++;
            if(temp<=0)return count;
            count++;


            // List<Float>list= new ArrayList<>();
            // while(!pq.isEmpty())
            // {
            //    float t=pq.poll()-1; 
            //    list.add(t); 
            // }
            // for(int i=0;i<list.size();i++)
            //      pq.add(list.get(i));
            
            
        }
        return count;
    }
}