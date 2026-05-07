class Solution {
    public boolean jump(int i, int[] nums,Boolean[] dp){
        if(i==nums.length-1)return true;
        if(i>=nums.length) return false;

        if(dp[i]!=null)return dp[i];

        int canJump = nums[i];
        while(canJump!=0){
            if(jump(i+canJump,nums,dp))
                return dp[i+canJump] = true;
            canJump--;
        }
        return dp[i] = false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return jump(0,nums,dp);
    }
}