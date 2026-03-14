class Solution {

    Integer[] dp;

    public int dfs(int pos, boolean tight, String n, String[] digits) {

        if (pos == n.length()) return 1;

        if (!tight && dp[pos] != null)
            return dp[pos];

        int limit = tight ? n.charAt(pos) - '0' : 9;
        int ans = 0;

        for (String d : digits) {

            int digit = d.charAt(0) - '0';

            if (digit > limit) continue;

            boolean newTight = tight && (digit == limit);

            ans += dfs(pos + 1, newTight, n, digits);
        }

        if (!tight)
            dp[pos] = ans;

        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;

        dp = new Integer[len];

        // numbers with smaller length
        for (int i = 1; i < len; i++) {
            ans += Math.pow(digits.length, i);
        }

        // numbers with same length
        ans += dfs(0, true, s, digits);

        return ans;
    }
}
