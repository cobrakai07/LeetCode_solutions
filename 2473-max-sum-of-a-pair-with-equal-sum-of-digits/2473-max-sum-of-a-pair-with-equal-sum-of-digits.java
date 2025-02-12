class Solution {
    public int sum(int num){
          int s=0;
        while(num!=0){
            int rem=num%10;
            s=s+rem;
            num=num/10;
        }
        return s;
    }
    public int maximumSum(int[] nums) {
        int []sumArray = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sumArray[i]=sum(nums[i]);
        }
        // System.out.println(Arrays.toString(sumArray));
        Map<Integer, PriorityQueue<Integer>>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.get(sumArray[i])==null){
                PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
                pq.offer(nums[i]);
                mp.put(sumArray[i],pq);
            }else{
                PriorityQueue<Integer>pq= mp.get(sumArray[i]);
                pq.offer(nums[i]);
            }
        }
        int max=-1;
        for(int k : mp.keySet()){
             PriorityQueue<Integer>pq= mp.get(k);
             if(pq.size()>=2){
                max=Math.max(max, pq.poll()+pq.poll());
             }
        }
        return max;
    }
}