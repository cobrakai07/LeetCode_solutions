class Solution {
    public int fun(int copyContent, int curr, int num, int[][]dp){

        if(curr>num)return 888888;
        if(curr==num)return 1;
        
        if(dp[copyContent][curr]!=Integer.MAX_VALUE)return dp[copyContent][curr];
        int copyAndPaste=Integer.MAX_VALUE;
        int paste=Integer.MAX_VALUE;

        copyAndPaste=2+fun(curr,curr+curr,num,dp);
        paste=1+fun(copyContent,curr+copyContent,num,dp);

        return  dp[copyContent][curr]=Math.min( copyAndPaste, paste );
    }
    public int minSteps(int n) {
        if(n==1)return 0;
        int [][]dp= new int[1001][1001];
        for(int []x: dp)Arrays.fill(x,Integer.MAX_VALUE);
        return fun(1,1,n,dp);
    }
}