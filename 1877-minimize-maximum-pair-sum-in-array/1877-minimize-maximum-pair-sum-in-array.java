class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MIN_VALUE;
        for(int i=0,j=nums.length-1;i<j;i++,j--)
        {
            if(nums[i]+nums[j]>min)
            {
                min=nums[i]+nums[j];
            }
        }
        return min;
    }
}