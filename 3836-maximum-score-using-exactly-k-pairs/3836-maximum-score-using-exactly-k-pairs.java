class Solution {
    final long NEG = Long.MIN_VALUE / 4;
    long[][][] dp;
    int[] a, b;

    public long dfs(int i, int j, int k) {

        // base cases
        if (k == 0) return 0;
        if (i == a.length || j == b.length) return NEG;

        // 🔥 PRUNING: not enough elements left
        if (a.length - i < k || b.length - j < k)
            return NEG;

        if (dp[i][j][k] != NEG)
            return dp[i][j][k];

        long res = NEG;

        // take current pair
        res = Math.max(res,
                1L * a[i] * b[j] + dfs(i + 1, j + 1, k - 1));

        // skip a[i]
        res = Math.max(res,
                dfs(i + 1, j, k));

        // skip b[j]
        res = Math.max(res,
                dfs(i, j + 1, k));

        return dp[i][j][k] = res;
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        this.a = nums1;
        this.b = nums2;

        int n = a.length, m = b.length;
        dp = new long[n][m][k + 1];

        for (long[][] x : dp)
            for (long[] y : x)
                Arrays.fill(y, NEG);

        return dfs(0, 0, k);
    }
}
