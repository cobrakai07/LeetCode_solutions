class Solution {
    public int removeDuplicates(int[] nums) {
        
        int idx1=0;
        int idx2=idx1+1;
        int ans=1; //1 <= nums.length // as minimum length of array is one

        while(idx2<nums.length)
        {
            if(nums[idx1]!=nums[idx2])
            {
                nums[++idx1]=nums[idx2];
                ans++;
            }
            idx2++;
        }

        return ans;
    }
}