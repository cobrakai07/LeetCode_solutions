class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[]ans=new int[nums.length];
        int idx=0;
        for(int x: nums)
        {
            if(x%2==0)
            {
                ans[idx++]=x;
            }
        }
        for(int x: nums)
        {
            if(x%2!=0)
            {
                ans[idx++]=x;
            }
        }
        return ans;

    }
}