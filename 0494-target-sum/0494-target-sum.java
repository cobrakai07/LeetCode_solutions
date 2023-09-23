class Solution {

    int ans=0;
    private int sum(int []arr)
    {
        int s=0;
        for(int x: arr)
        {
            s=s+x;
        }
        return s;
    }
    private void fun(int idx,int[]nums,int target)
    {
        if(idx==nums.length)
        {
            if(target==sum(nums))
              ans++;
            return;
        }

        nums[idx]=-nums[idx];
        fun(idx+1,nums,target);
        nums[idx]=-nums[idx];

        fun(idx+1,nums,target);
    }
    public int findTargetSumWays(int[] nums, int target) {
       fun(0,nums,target);
       return ans; 
    }
}