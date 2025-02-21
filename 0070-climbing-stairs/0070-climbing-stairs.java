class Solution {
    public int fun(int n){
        if(n==0)return 1;
        if(n<0)return 0;
        return fun(n-1)+fun(n-2);
    }
    public int funMemo(int n, int[]dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n]= fun(n-1)+fun(n-2);
    }
    public int climbStairs(int n) {
        // int[]dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return funMemo(n,dp);

        // dp[0]=1;

        // for(int i=1; i<=n ;i++){
        //     int one=0, two=0;
        //     if(i-1>=0)one=dp[i-1];
        //     if(i-2>=0)two=dp[i-2];
        //     dp[i]=one+two;
        // }

        // return dp[n];

        int pre1=1, pre2=0;

        for(int i=0; i<=n ;i++){
            int t=pre2;
            pre2=pre1+pre2;
            pre1=t;
        } 
        return pre2;
    }
}