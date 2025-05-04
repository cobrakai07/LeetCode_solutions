class Solution {
    int fun(int i, int amount, int[] coins, Integer[][] dp) {
        if (i == 0) {
            if (amount % coins[0] != 0)
                return 0;
            else
                return 1;
        }

        if (dp[i][amount] != null)
            return dp[i][amount];
        int pick = 0, npick = 0;
        if (amount >= coins[i])
            pick = fun(i, amount - coins[i], coins, dp);

        npick = fun(i - 1, amount, coins, dp);

        return dp[i][amount] = pick + npick;
    }

    public int change(int amount, int[] coins) {
        // Integer[][]dp = new Integer[coins.length][amount+1];
        // return fun(coins.length-1,amount,coins,dp);
        int[][]dp = new int[coins.length][amount+1];
      
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0)dp[0][i]=1;
        }

        for(int i=1;i<coins.length; i++){
            for(int j=0; j<=amount; j++)
            {
                int pick=0,npick=0;
                if(j>=coins[i])
                     pick= dp[i][j-coins[i]];
        
                npick=dp[i-1][j];

            dp[i][j]=pick+npick;
            }
        }

        return dp[coins.length-1][amount];
    }
}