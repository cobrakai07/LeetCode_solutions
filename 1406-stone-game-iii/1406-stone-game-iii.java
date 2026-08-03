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

    public int funIterative(int n, int[] arr, int[] dp) {

        for (int i = n - 1; i >= 0; i--) {
            
            dp[i] = arr[i] - dp[i + 1];
            if (i + 1 < n)
                dp[i] = Math.max(dp[i] , arr[i] + arr[i + 1] - dp[i + 2]);
            if (i + 2 < n)
                dp[i] = Math.max(dp[i] , arr[i] + arr[i + 1] + arr[i + 2] - dp[i + 3]);
        }

        return dp[0];

    }

    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 3];
        // Arrays.fill(dp, Integer.MIN_VALUE / 2);
        // int val = fun(0, stoneValue.length, stoneValue, dp);
        int val = funIterative(stoneValue.length, stoneValue, dp);
        return val == 0 ? ("Tie") : (val < 1 ? "Bob" : "Alice");
    }
}