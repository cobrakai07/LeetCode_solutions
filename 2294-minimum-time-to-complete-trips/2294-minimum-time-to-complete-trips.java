class Solution {
    public boolean isPossible(long timePerTrip, int totalTrips, int[] time) {
        long tripsDone = 0;
        for (int t : time) {
            tripsDone += timePerTrip / t;
            if (tripsDone >= totalTrips) return true; 
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        
        long ans = 0;
        long low = 1, high = (long) Arrays.stream(time).min().getAsInt() * totalTrips; 

        while(low<=high){
            long mid = low+(high-low)/2;
            if(isPossible(mid,totalTrips,time)){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }

        return ans*1L;
    }
}