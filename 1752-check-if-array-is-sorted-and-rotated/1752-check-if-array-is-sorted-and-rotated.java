class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;

        if(n==1)return true;

        int max = nums[n-1];
        boolean flag = false;
        int i =n-2;

        for(;i>=0;i--){
            if(nums[i]>nums[i+1]){
                flag = true;
                i--;
               break;
            }
        }

        for(;i>=0;i--){
            if(nums[i]>nums[i+1]){
               return false;
            }
        }
        if(flag){
            return max<=nums[0];
        }
        return true;
    }
}