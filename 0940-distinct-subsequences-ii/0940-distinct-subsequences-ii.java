class Solution {

    static final int MOD = 1_000_000_007;
    int[] dp;

    public int fun(int i, String s, int[] prev) {

        if (i == -1)
            return 1;

        if (dp[i] != -1)
            return dp[i];

        long total = 2L * fun(i - 1, s, prev);

        if (prev[i] != -1) {
            total -= fun(prev[i] - 1, s, prev);
        }

        total = (total + MOD) % MOD;

        return dp[i] = (int) total;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();

        dp = new int[n];

        int[] prev = new int[n];
        int[] seen = new int[26];

        Arrays.fill(seen, -1);
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {

            int idx = s.charAt(i) - 'a';

            prev[i] = seen[idx];

            seen[idx] = i;
        }

        return (fun(n - 1, s, prev) - 1 + MOD) % MOD;
    }
}