class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->a-b);
        while(n!=0){
            pq.offer(n);
            n--;
        }
        Set<Integer>set= new HashSet<>();
        for(int i: banned)
            set.add(i);
        int ans=0;
        int sum=0;
        while(!pq.isEmpty()){
            int num=pq.poll();
            if(!set.contains(num) && sum+num <=maxSum){
                sum=sum+num;
                ans++;
            }
        }
        return ans;
    }
}