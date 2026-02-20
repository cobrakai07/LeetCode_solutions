class Solution {
    int[][] dp;

    public int solve(int i, int j, int[] arr) {
        if (j - i <= 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;

        for (int k = i + 1; k < j; k++) {
            int coins = arr[i] * arr[k] * arr[j]
                      + solve(i, k, arr)
                      + solve(k, j, arr);

            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, n + 1, arr);
    }
}