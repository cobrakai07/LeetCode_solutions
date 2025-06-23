class Solution {
    public int fun(int n, int num, Integer[]dp){
        if(n==num)return 1;
        if(n>num)return 0;
        if(dp[n]!=null)return dp[n];
        int max = 0;
        // System.out.println(n);
        for(int i=1;i<num;i++){
            max = Math.max(max,i*fun(n+i,num,dp));
        }
        return dp[n]=max;
    }
    // public int fun(int n){
    //     if(n==0)return 1;
    //     if(n<0)return 0;

    //     int max = 0;
    //     // System.out.println(n);
    //     for(int i=1;i<n;i++){
    //         max = Math.max(max,i*fun(n-i));
    //     }
    //     return max;
    // }
    public int integerBreak(int n) {
        Integer[]dp = new Integer[n+1];
        return fun(0,n,dp);
    }
}