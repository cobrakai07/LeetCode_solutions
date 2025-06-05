class Solution {
    public int missingNumber(int[] nums) {
        int s = 0;
        for(int i: nums)s+=i;
        int n = nums.length;
        return  ((n*(n+1))/2)-s;
    }
}