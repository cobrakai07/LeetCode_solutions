class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer,PriorityQueue<Integer>>mp = new HashMap<>();
        for(int i=0; i< x.length; i++){
            if(mp.get(x[i])==null){
                PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)-> Integer.compare(b,a));
                pq.offer(y[i]);
                mp.put(x[i],pq);
            }
            else{
                PriorityQueue<Integer>pq= mp.get(x[i]);
                pq.offer(y[i]);
                mp.put(x[i],pq);
            }
        }
        if(mp.size()<3)return -1;
        List<Integer>list = new ArrayList<>();
        for(int k : mp.keySet()){
            list.add(mp.get(k).peek());
        }
        Collections.sort(list,(a,b)->Integer.compare(b,a));
        return list.get(0)+list.get(1)+list.get(2);
    }
}