class Solution {
    public boolean fun(int i, int sum, int[] nums, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i == nums.length) return false;
        if (dp[i][sum] != null) return dp[i][sum];
        
        boolean pick = false;
        if (sum - nums[i] >= 0)
            pick = fun(i + 1, sum - nums[i], nums, dp);
        boolean notPick = fun(i + 1, sum, nums, dp);
        
        return dp[i][sum] = pick || notPick;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        
        return fun(0, target, nums, dp);
    }
}
