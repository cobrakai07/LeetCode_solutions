class Solution {
    int fun(int i, int amount , int[]coins, Integer[][]dp){
        if(i==coins.length)
            return amount==0?1:0;
        if(dp[i][amount]!=null)return dp[i][amount];
        int pick=0,npick=0;
        if(amount>=coins[i])
            pick=fun(i,amount-coins[i],coins,dp);
        
        npick=fun(i+1,amount,coins,dp);

        return dp[i][amount]=pick+npick;
    }
    public int change(int amount, int[] coins) {
        Integer[][]dp = new Integer[coins.length][amount+1];
        return fun(0,amount,coins,dp);
    }
}