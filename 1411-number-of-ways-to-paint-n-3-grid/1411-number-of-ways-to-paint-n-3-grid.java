class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] dp;

    int fun(int row, int prevMask, int n) {
        if (row == n) return 1;

        if (dp[row][prevMask] != null)
            return dp[row][prevMask];

        int ans = 0;

        for (int mask = 0; mask < 27; mask++) {
            int[] cur = decode(mask);
            int[] prev = decode(prevMask);

            // horizontal constraint
            if (cur[0] == cur[1] || cur[1] == cur[2]) continue;

            // vertical constraint
            if (row > 0) {
                if (cur[0] == prev[0] ||
                    cur[1] == prev[1] ||
                    cur[2] == prev[2]) continue;
            }

            ans = (ans + fun(row + 1, mask, n)) % MOD;
        }

        return dp[row][prevMask] = ans;
    }

    int[] decode(int mask) {
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = mask % 3;
            mask /= 3;
        }
        return a;
    }

    public int numOfWays(int n) {
        dp = new Integer[n][27];
        return fun(0, 0, n);
    }
}
