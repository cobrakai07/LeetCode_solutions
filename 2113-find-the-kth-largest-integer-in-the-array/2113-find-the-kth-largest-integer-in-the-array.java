class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String>pq = new PriorityQueue<>(
            (a,b)->{
                if(a.length()>b.length())return 1;
                if(a.length()<b.length())return -1;
                for(int i=0;i<a.length();i++){
                    int a1=a.charAt(i)-'0';
                    int b1=b.charAt(i)-'0';
                    if(a1>b1)return 1;
                    if(a1<b1)return -1;
                }
              return 0;
            }
        );
        for(String i: nums){
            pq.offer(i);
            if(pq.size()>k)pq.poll();
        }
        // System.out.println(pq);
        return pq.peek();
    }
}