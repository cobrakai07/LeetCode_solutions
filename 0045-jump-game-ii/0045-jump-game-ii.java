class Solution {
    public int minJump(int i, int[] nums, int[] dp){
        if(i==nums.length-1)return 0;
        if(i>=nums.length)return Integer.MAX_VALUE/2;
        if(dp[i]!=Integer.MAX_VALUE/2)return dp[i];
        
        int temp = nums[i];
        int min = Integer.MAX_VALUE/2;

        while(temp!=0){
            int localMin = 1 + minJump(i+temp,nums,dp);
            min = Math.min(localMin, min);
            temp--;
        }

        return dp[i] = min;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        return minJump(0,nums,dp);
    }
}