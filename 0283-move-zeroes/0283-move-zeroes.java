class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int it = 0; it< nums.length ;it++){
            if(nums[it]!=0){
                nums[i++]=nums[it];
            }
        }
        while(i<nums.length)nums[i++]=0;
    }
}