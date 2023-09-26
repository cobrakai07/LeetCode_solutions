class Solution {
    public int[] fun(int []nums)
    {
        int []newNums=new int [nums.length];
        for(int i=0;i<nums.length-1;i++)
        {
            newNums[i] = (nums[i] + nums[i+1]) % 10;
        }
        nums=newNums;
        return nums;
    }
    public int triangularSum(int[] nums) {
        if(nums.length==1)return nums[0];
        int count=nums.length-1;
        while(count!=0)
        {
            nums=fun(nums);
            count--;
        }
        return nums[0];
    }
}