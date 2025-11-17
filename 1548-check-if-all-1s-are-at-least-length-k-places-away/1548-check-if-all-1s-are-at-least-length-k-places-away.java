class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        for(; i<nums.length; i++){
            if(nums[i]==1)break;
        }
        i++;
        int distance = 0; 
        for(; i<nums.length; i++){
            if(nums[i]==1){
                if(distance<k)return false; 
                distance = 0;
            }else{
                distance++;
            }
        }
        return true; 
    }
}