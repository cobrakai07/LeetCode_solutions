class Solution {
    public int fun(int i, int []nums,Integer[]dp){
        if(i==nums.length-1)return 0;
        if(i>nums.length-1)return 9999999;
        if(dp[i]!=null)return dp[i];
        int jumps = nums[i];
        int minJump = 9999999;
        for(int j=1;j<=jumps;j++){
           minJump = Math.min(minJump, 1+ fun(i+j,nums,dp)) ;
        }
        return dp[i]=minJump;
    }
    public int jump(int[] nums) {
        Integer[]dp = new Integer[nums.length];
        return fun(0,nums,dp);
    }
}