class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        // Memoization array
        Boolean[][] dp = new Boolean[n][n + 1];
        
        // Recursive function with memoization
        return check(s, 0, 0, dp);
    }

    private boolean check(String s, int i, int balance, Boolean[][] dp) {
        if (balance < 0) return false; // More ')' than '('
        if (i == s.length()) return balance == 0; // All characters processed, balance should be 0
        
        if (dp[i][balance] != null) return dp[i][balance]; // Return memoized result
        
        char c = s.charAt(i);
        boolean result;
        if (c == '(') {
            result = check(s, i + 1, balance + 1, dp);
        } else if (c == ')') {
            result = check(s, i + 1, balance - 1, dp);
        } else { // c == '*'
            result = check(s, i + 1, balance + 1, dp) || // Treat '*' as '('
                     check(s, i + 1, balance - 1, dp) || // Treat '*' as ')'
                     check(s, i + 1, balance, dp);       // Treat '*' as empty
        }
        
        dp[i][balance] = result; // Memoize the result
        return result;
    }
}
