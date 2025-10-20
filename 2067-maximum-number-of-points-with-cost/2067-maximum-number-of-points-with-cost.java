class Solution {

    long[][] dp;
    int[][] points;
    int m, n;

    public long solve(int i, int j) {
        // Base case: reached after the last row
        if (i == m) return 0;

        // If already computed
        if (dp[i][j] != Long.MIN_VALUE) return dp[i][j];

        // Compute max values for next row first (prefix/suffix trick)
        long[] nextRow = new long[n];
        if (i == m - 1) {
            // Last row: just take its values
            for (int k = 0; k < n; k++) nextRow[k] = points[i][k];
        } else {
            // Compute dp[i+1][*] first (recursively)
            for (int k = 0; k < n; k++) {
                if (dp[i + 1][k] == Long.MIN_VALUE) solve(i + 1, k);
            }

            // Prefix max (left to right)
            long[] left = new long[n];
            left[0] = dp[i + 1][0];
            for (int k = 1; k < n; k++)
                left[k] = Math.max(left[k - 1] - 1, dp[i + 1][k]);

            // Suffix max (right to left)
            long[] right = new long[n];
            right[n - 1] = dp[i + 1][n - 1];
            for (int k = n - 2; k >= 0; k--)
                right[k] = Math.max(right[k + 1] - 1, dp[i + 1][k]);

            for (int k = 0; k < n; k++)
                nextRow[k] = Math.max(left[k], right[k]) + points[i][k];
        }

        // Store computed results for current row
        for (int k = 0; k < n; k++)
            dp[i][k] = nextRow[k];

        return dp[i][j];
    }

    public long maxPoints(int[][] points) {
        this.points = points;
        m = points.length;
        n = points[0].length;
        dp = new long[m][n];
        for (long[] row : dp) Arrays.fill(row, Long.MIN_VALUE);

        // Ensure first row is computed (recursively fills all)
        long ans = Long.MIN_VALUE;
        solve(0, 0);

        // Take max from first row
        for (int j = 0; j < n; j++) ans = Math.max(ans, dp[0][j]);
        return ans;
    }
}
