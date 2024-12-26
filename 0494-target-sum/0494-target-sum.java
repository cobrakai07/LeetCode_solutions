class Solution {
    private int fun(int idx,int[]nums,int currSum,int target)
    {
        if(idx==nums.length)
        {
            if(target==currSum)
                return 1;
            else
                return 0;
        }
        int m=0,n=0;
        nums[idx]=-nums[idx];
        m+=fun(idx+1,nums,currSum+nums[idx],target);
        nums[idx]=-nums[idx];
        n+=fun(idx+1,nums,currSum+nums[idx],target);
        return m+n;
    }
    public int findTargetSumWays(int[] nums, int target) {
       return fun(0,nums,0,target);
    }
}