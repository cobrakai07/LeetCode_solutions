class Solution {
    public int maximumProduct(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        max = Math.max(max, nums[n-1]*nums[n-2]*nums[n-3]);
        max = Math.max(max, nums[n-1]*nums[0]*nums[1]);
        return max;
    }
}