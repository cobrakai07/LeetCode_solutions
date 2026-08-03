class Solution {
    public int fun(int i, int n, int[] arr, int[] dp) {
        if (i >= n)
            return 0;
        if (dp[i] != Integer.MIN_VALUE / 2)
            return dp[i];
        int max = Integer.MIN_VALUE / 2;
        max = Math.max(max, arr[i] - fun(i + 1, n, arr, dp));
        if (i + 1 < n)
            max = Math.max(max, arr[i] + arr[i + 1] - fun(i + 2, n, arr, dp));
        if (i + 2 < n)
            max = Math.max(max, arr[i] + arr[i + 1] + arr[i + 2] - fun(i + 3, n, arr, dp));

        return dp[i] = max;

    }

    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, Integer.MIN_VALUE / 2);
        int val = fun(0, stoneValue.length, stoneValue, dp);
        return val == 0 ? ("Tie") : (val < 1 ? "Bob" : "Alice");
    }
}