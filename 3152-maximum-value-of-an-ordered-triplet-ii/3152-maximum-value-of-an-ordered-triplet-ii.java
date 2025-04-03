class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int [] preMax= new int[n];
        int [] postMax= new int[n];

        preMax[0]=nums[0];postMax[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
            preMax[i]=Math.max(preMax[i-1],nums[i]);
        for(int i=n-2;i>=0;i--)
            postMax[i]=Math.max(nums[i],postMax[i+1]);
        
        long max=0;

        for(int i=0; i<n-1 ;i++)
            max=Math.max(max, (preMax[i]-nums[i])*(postMax[i+1]*1L));
        
        return max;
    }
}