class Solution {
    public long maxScore(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        long NEG = Long.MIN_VALUE / 4;

        long[][][] dp = new long[n + 1][m + 1][k + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                Arrays.fill(dp[i][j], NEG);

        dp[0][0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int x = 0; x <= k; x++) {
                    if (dp[i][j][x] == NEG) continue;

                    // skip a[i]
                    if (i < n)
                        dp[i + 1][j][x] = Math.max(dp[i + 1][j][x], dp[i][j][x]);

                    // skip b[j]
                    if (j < m)
                        dp[i][j + 1][x] = Math.max(dp[i][j + 1][x], dp[i][j][x]);

                    // take pair
                    if (i < n && j < m && x < k) {
                        dp[i + 1][j + 1][x + 1] =
                            Math.max(dp[i + 1][j + 1][x + 1],
                                     dp[i][j][x] + 1L * a[i] * b[j]);
                    }
                }
            }
        }

        return dp[n][m][k];
    }
}
