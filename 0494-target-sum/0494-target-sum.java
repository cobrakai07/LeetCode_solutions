class Solution {
    int fun(int i, int t, int []nums){
        if(i==nums.length){
           return t==0? 1: 0;
        }
        int pick= fun(i+1,t-nums[i],nums);
        int npick= fun(i+1,t,nums);

        return pick+npick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int s=0;
        for(int i: nums)s+=i;
        if(s-target<0 || ((s-target)&1)==1)return 0;
        return fun(0,(s-target)/2,nums);
    }
}