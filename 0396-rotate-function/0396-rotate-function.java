class Solution {
    public int maxRotateFunction(int[] nums) {
        int F =  0;
        int sum = 0;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            F += (nums[i]*i);
            sum += nums[i];
        }

        int max = F;

        for(int i=0;i<n;i++){
            int currMax = F + sum - (n*nums[n-1-i]);
            F = currMax;
            max = Math.max(currMax,max);
        }

        return max;
    }
}