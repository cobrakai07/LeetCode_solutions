class Solution {
    public boolean validate(long val , int []arr, int n){
        long power = 0;
        for(int i: arr){
            long consume = i>=val?val:i;
            power += consume;
        }
        return power>=val*n;
    }
    public long maxRunTime(int n, int[] batteries) {
        long max = 0;
        long min = Integer.MAX_VALUE;
        for(int i: batteries){
            min = Math.min(i,min);
            max += i;
        }

        long ans = max;
         while(max>=min){
            long mid = min+(max-min)/2;
            if(validate(mid,batteries,n)){
                min = mid+1;
                ans = mid;
            }else{
                max = mid-1;
            }
         }
         return ans;
        
        
    }
}