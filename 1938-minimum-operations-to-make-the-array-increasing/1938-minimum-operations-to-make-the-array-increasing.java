class Solution {
    public int minOperations(int[] nums) {
        int inc=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1])
            {
                inc+=(nums[i-1]-nums[i])+1;
                nums[i]= nums[i]+(nums[i-1]-nums[i])+1;
            }
        }
        return inc;
    }
}