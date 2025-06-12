class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            // System.out.println(i+" "+((i+1)%(nums.length)));
            max= Math.max(max, Math.abs(nums[i]-nums[(i+1)%(nums.length)]));
        }
        return max;
    }
}