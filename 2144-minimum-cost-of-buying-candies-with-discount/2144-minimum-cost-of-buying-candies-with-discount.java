class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length<3){
            int s =0;
            for(int i: cost)s+=i;
            return s;
        }
        Arrays.sort(cost);
        
        int c=0;
        int last = cost.length-1;
        int secondLast = cost.length-2;
        int rem = cost.length%3;
        int loop = cost.length/3;
 
        while(loop!=0 && secondLast>=0){
            c += (cost[last] + cost[secondLast]);
            last = last -3;
            secondLast = secondLast - 3;
            loop--;
            // System.out.println(loop);
            //  1 2 3 4 5 5 6
        }
        if(rem!=0){
            int idx = 0;
            while(rem!=0){
                c+= cost[idx];
                idx++;
                rem--;
            }
        }
        // System.out.println(Arrays.toString(cost));
        return c;
    }
}