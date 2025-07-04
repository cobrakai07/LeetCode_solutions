class Solution {
    public boolean fun(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        if (i + j == s3.length()) return true; // successfully built all of s3

        if (dp[i][j] != null) return dp[i][j];

        boolean first = false, second = false;

        // Try to take one character from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            first = fun(i + 1, j, s1, s2, s3, dp);
            if (first) return dp[i][j] = true;
        }

        // Try to take one character from s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            second = fun(i, j + 1, s1, s2, s3, dp);
            if (second) return dp[i][j] = true;
        }

        return dp[i][j] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return fun(0, 0, s1, s2, s3, dp);
    }
}
