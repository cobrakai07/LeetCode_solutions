class Solution {
    public long fun(int i, int j, int[]a, int[]b, long[][]dp){
        if(i==a.length){
            return 0;
        }
        if(i<a.length && j>=b.length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=-1)return dp[i][j];

        long pick=(long)a[i]*b[j]+fun(i+1,j+1,a,b,dp);
        long notpick=fun(i,j+1,a,b,dp);
        return dp[i][j]=Math.max(pick,notpick);
    }
    public long maxScore(int[] a, int[] b) {
        long[][]dp = new long[a.length][b.length];
        for(long []arr: dp)Arrays.fill(arr,-1);
        return fun(0,0,a,b,dp);
    }
}