class Solution {
    public int fun(int idx, int k, int []energy, int[]dp){
        if(idx>=energy.length){
            return 0;
        }
        if(dp[idx+1]!=-1)return dp[idx+1];
        int pick = Integer.MIN_VALUE;
        if(idx== -1){
            for(int i=0;i<energy.length; i++){
                int max = energy[i]+fun(i+k,k,energy, dp);
                pick = Math.max(max,pick);
            }
        }else{
            pick = energy[idx]+fun(idx+k, k, energy,dp);
        }

        return dp[idx+1]=pick;

    }
    public int maximumEnergy(int[] energy, int k) {
        int []dp = new int[energy.length+1];
        Arrays.fill(dp,-1);
        return fun(-1,k, energy,dp);
    }
}