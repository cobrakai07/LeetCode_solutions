class Solution {
    int ans=0;
    private void fun(int idx,int[]nums,int currSum,int target)
    {
        if(idx==nums.length)
        {
            if(target==currSum)
              ans++;
            return;
        }
        nums[idx]=-nums[idx];
        fun(idx+1,nums,currSum+nums[idx],target);
        nums[idx]=-nums[idx];
        fun(idx+1,nums,currSum+nums[idx],target);
    }
    public int findTargetSumWays(int[] nums, int target) {
       fun(0,nums,0,target);
       return ans; 
    }
}