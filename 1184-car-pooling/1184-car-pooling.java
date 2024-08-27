record Pair(int cap, int till){

}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a,b)-> {
            if(a[1]==b[1])return a[2]-b[2];
            return a[1]-b[1];
        });

        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->a.till()-b.till());

        int cc=trips[0][0];
        if(cc>capacity)return false;
        pq.offer(new Pair(trips[0][0], trips[0][2]));

        for(int i=1; i<trips.length; i++){
                // System.out.println(pq);
                while(!pq.isEmpty() && pq.peek().till()<= trips[i][1])
                    cc=cc-pq.poll().cap();
                
                pq.offer(new Pair(trips[i][0], trips[i][2]));
                if(cc+trips[i][0]>capacity)return false;
                else cc+=trips[i][0];
                
        }

        return true;
        
    }
}