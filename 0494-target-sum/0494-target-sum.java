class Solution {
    int fun(int i, int t, int []nums, Integer[][]dp){
        if(i==nums.length){
           return t==0? 1: 0;
        }
        if(t<0)return 0;
        if(dp[i][t]!=null)return dp[i][t];
        int pick= fun(i+1,t-nums[i],nums,dp);
        int npick= fun(i+1,t,nums,dp);

        return dp[i][t]=pick+npick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int s=0;
        for(int i: nums)s+=i;
        if(s-target<0 || ((s-target)&1)==1)return 0;
        int size= target<0?s-target:s+1;
        Integer[][]dp = new Integer[nums.length][size];
        return fun(0,(s-target)/2,nums,dp);
    }
}