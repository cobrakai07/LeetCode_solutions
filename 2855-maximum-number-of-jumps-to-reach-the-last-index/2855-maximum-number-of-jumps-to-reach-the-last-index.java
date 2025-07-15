class Solution {
    public int fun(int i, int t, int[] nums, Integer[] dp) {
        if (i == nums.length - 1) return 0;
        if (dp[i] != null) return dp[i];

        int max = -1;
        for (int ii = i + 1; ii < nums.length; ii++) {
            long res = (long) nums[ii] - nums[i];
            if (res >= -t && res <= t) {
                int next = fun(ii, t, nums, dp);
                if (next != -1) {
                    max = Math.max(max, 1 + next);
                }
            }
        }

        return dp[i] = max;
    }

    public int maximumJumps(int[] nums, int target) {
        Integer[] dp = new Integer[nums.length];
        return fun(0, target, nums, dp);
    }
}
