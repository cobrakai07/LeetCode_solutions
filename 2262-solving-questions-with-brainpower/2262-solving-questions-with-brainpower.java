class Solution {
    public long fun(int i, int[][]q, long[]dp){
        // System.out.println(i);
        if(i>=q.length)return 0L;
        if(dp[i]!=-1)return dp[i];
        long pick= q[i][0]+ fun(i+q[i][1]+1, q,dp);
        long notPick= 0L + fun(i+1, q,dp);
        return dp[i] = Math.max(pick, notPick);
    }
    public long mostPoints(int[][] questions) {
        long[]dp= new long[questions.length];
        Arrays.fill(dp,-1);
        return fun(0,questions,dp);
    }
}