class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long sum = 0;
        Arrays.sort(nums);
        int idx = nums.length-1;
        while(mul>0 && k>0){
            k--;
            sum = sum+ (1l*mul*nums[idx--]);
            mul--;
        }
        // System.out.println(sum);
        while(k>0){
            sum = sum+nums[idx--];
            k--;
        }
        return sum;
    }
}