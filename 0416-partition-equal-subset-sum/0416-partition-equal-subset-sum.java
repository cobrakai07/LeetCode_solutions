class Solution {
    public boolean fun(int i, int t, int[]arr,Boolean[][]dp){
        if(i==arr.length){
            if(t==0)return true;
            else return false;
        }
        if(t==0)return true;
        if(t<0)return false;
        if(dp[i][t]!=null)return dp[i][t];
        boolean pick = fun(i+1, t-arr[i], arr,dp);
        boolean npick = fun(i+1, t, arr,dp);

        return  dp[i][t]=pick||npick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i: nums)sum+=i;
        if(sum%2==1)return false;

        Boolean[][]dp= new Boolean[nums.length][sum+1];
        return fun(0,sum/2,nums,dp);
    }
}