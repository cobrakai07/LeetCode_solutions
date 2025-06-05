class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=0;
        int unique=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                while(j<nums.length&&nums[i]==nums[j]) j++;
                i++;
                unique++;
                if(j<nums.length)
                    nums[i]=nums[j];
            }
    }
    return  unique;}
}