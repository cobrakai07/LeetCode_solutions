class Solution {

    Integer[][] dp;

    public int dfs(int pos, int tight, String n, String[] digits) {

        if (pos == n.length()) return 1;

        if (dp[pos][tight] != null)
            return dp[pos][tight];

        int limit = tight==1 ? n.charAt(pos) - '0' : 9;
        int ans = 0;

        for (String d : digits) {

            int digit = d.charAt(0) - '0';

            if (digit > limit) continue;

            int newTight = (tight==1 && (digit == limit))?1:0;

            ans += dfs(pos + 1, newTight, n, digits);
        }

        return dp[pos][tight] = ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;

        dp = new Integer[len][2];

        // numbers with smaller length
        for (int i = 1; i < len; i++) {
            ans += Math.pow(digits.length, i);
        }

        // numbers with same length
        ans += dfs(0, 1, s, digits);

        return ans;
    }
}
