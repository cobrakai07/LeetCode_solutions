class Solution {
    public int fun(int i, int j, int[][]dp){
        if(i==dp.length-1 && j == dp[0].length-1)return 1;
        if(i==dp.length||j==dp[0].length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int down = fun(i+1,j,dp);
        int right= fun(i,j+1,dp);
        return dp[i][j]=right+down;
    }
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        for(int[]a: dp)Arrays.fill(a,-1);
        return fun(0,0,dp);
    }
}