class Solution {
    int lowestPrimeFactor(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0) return i;
        }
        return x;
    }
    public int minOperations(int[] nums) {
        int n=nums.length,min_operations=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                min_operations++;
                nums[i]=lowestPrimeFactor(nums[i]);
            }
            if(nums[i]>nums[i+1]){
                return -1;
            }
        }
        return min_operations;
    }
}