class Solution {
    public int fun(int i, int p, int[] nums,Integer[]dp){
        // if(p-i==0)return Integer.MIN_VALUE;
        if(i>=nums.length)return 0;
        if(dp[i]!=null)return dp[i];
        int pick = 0;
        int notpick =0;

        notpick=fun(i+1,i,nums,dp);
        pick=nums[i]+fun(i+2,i,nums,dp);

        return dp[i]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        Integer[]dp = new Integer[nums.length];
        return fun(0,-1,nums,dp);
    }
}