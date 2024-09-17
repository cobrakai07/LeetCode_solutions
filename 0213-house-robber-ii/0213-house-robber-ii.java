class Solution {
    public int fun(int i, int j, int[]arr, int[]dp){
        if(i>j){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        return dp[i]=Math.max(fun(i+2,j,arr,dp)+arr[i],fun(i+1,j,arr,dp)); 
    }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int []dp1=new int[nums.length];
        Arrays.fill(dp1,-1);
        return Math.max(fun(0,nums.length-2,nums,dp),fun(1,nums.length-1,nums,dp1));
    }
}