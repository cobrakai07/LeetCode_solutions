class Solution {
    public int longestSubarray(int[] nums) {
        int s=0,e=0;
        int max=0;
        boolean hasOneZero=false;
        while(e<nums.length)
        {
            // System.out.println(s+","+e+"  "+hasOneZero);
            if(nums[e]==1)
            {
                if(max<e-s)max=e-s;
                e++;
            }
            else if(nums[e]==0&&!hasOneZero)
            {
                 if(max<e-s)max=e-s;
                e++;
                hasOneZero=true;
               
            }
            else if(nums[e]==0&&hasOneZero)
            {
                while(nums[s]!=0)
                {
                    s++;
                }
                hasOneZero=false;
                s++;
            }
        }
        return max;
    }
}