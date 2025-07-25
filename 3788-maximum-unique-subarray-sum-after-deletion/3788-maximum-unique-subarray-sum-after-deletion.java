class Solution {
    public int maxSum(int[] nums) {
        Set<Integer>set= new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max = 0;
        int curr = 0;
        boolean hasPositive = false;
        Iterator<Integer> it =  set.iterator();

        while(it.hasNext()){
            int i = it.next();
            if(i>=0) hasPositive=true;
            curr = Math.max(i+curr,curr);
            max = Math.max(max,curr);
        }

        if(!hasPositive){
            int localMax=-Integer.MAX_VALUE;
            for(int i: nums)localMax= Math.max(localMax,i);
            return localMax;
        }
        
        return max;
    }
}