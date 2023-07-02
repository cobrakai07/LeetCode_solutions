class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum=Integer.MIN_VALUE;
        int currSum=-100000;//resuting in overflow if taking Integer.MIN_VALUE//
        for(int i=0;i<nums.length;i++)
        {
            currSum=Math.max(nums[i],nums[i]+currSum);
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}