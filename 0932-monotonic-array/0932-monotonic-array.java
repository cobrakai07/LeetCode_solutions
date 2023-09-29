class Solution {
    private boolean fun1(int x,int y,int[]nums)
    {
        for(int i=x,j=y;i<nums.length&&j<nums.length;i++,j++)
        {
            if(nums[j]-nums[i]<0)
              return false;
        }
        return true;
    }
    private boolean fun2(int x,int y,int[]nums)
    {
        for(int i=x,j=y;i<nums.length&&j<nums.length;i++,j++)
        {
            if(nums[i]-nums[j]<0)
              return false;
        }
        return true;
    }
    public boolean isMonotonic(int[] nums) {
       if(nums.length==1)return true;
       for(int i=0,j=1;i<nums.length&&j<nums.length;i++,j++)
       {
           if(nums[i] <= nums[j])
           {
               if( nums[i] < nums[j])
               return fun1(i,j,nums);
           }
           else if( nums[i] > nums[j])
           {
               if(nums[i] > nums[j])
                return fun2(i,j,nums);
           }
       }
       return true; 
    }
}