class Solution {
    int fun(int i, int j, int m, int n, int neutral, int [][] coins ,int[][][] dp){

        if(i==m-1 && j==n-1){
            return (neutral>0 && coins[i][j]<0) ? 0: coins[i][j];
        }
        if(i==m || j==n){
            return Integer.MIN_VALUE/2;
        }

        if(dp[i][j][neutral] != Integer.MIN_VALUE/2) return dp[i][j][neutral];

        if(coins[i][j]<0 && neutral>0){
            int rightNeutralize = 0 + fun(i,j+1,m,n,neutral-1,coins,dp);
            int downNeutralize = 0 + fun(i+1,j,m,n,neutral-1,coins,dp);

            int right = coins[i][j] + fun(i,j+1,m,n,neutral,coins,dp);
            int down = coins[i][j] + fun(i+1,j,m,n,neutral,coins,dp); 

            return dp[i][j][neutral] = Math.max(Math.max(right,down) , Math.max(rightNeutralize, downNeutralize));           
        }else{
            int right = coins[i][j] + fun(i,j+1,m,n,neutral,coins,dp);
            int down = coins[i][j] + fun(i+1,j,m,n,neutral,coins,dp);
            return dp[i][j][neutral] = Math.max(right, down);
        }
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for(int [][]a: dp){
            for(int []b: a)
                Arrays.fill(b,Integer.MIN_VALUE/2);
        }
        return fun(0,0,m,n,2,coins,dp);
    }
}