// Digit Dp 
class Solution {
    // Define the modulo constant
    final int MOD = 1_000_000_007;

    // 4D DP memoization table:
    // dp[position][tightFlag][digitSum][dummy]
    // dummy is used to keep array 4D because Java doesn't allow variable-size array in 3D for sum
    Integer[][][][] dp;

    // Digit DP recursive function
    public int fun(int i, int tight, int sum, int max_sum, int min_sum, String str) {
        // Base case: if we've processed all digits
        if (i == str.length()) {
            // Check if digit sum is within the allowed range
            return (sum >= min_sum && sum <= max_sum) ? 1 : 0;
        }

        // Return already computed result if available
        if (dp[i][tight][sum][0] != null) return dp[i][tight][sum][0];

        // Determine the digit limit based on the tight flag
        int limit = (tight == 1) ? (str.charAt(i) - '0') : 9;

        int res = 0;

        // Try placing each digit from 0 to limit
        for (int d = 0; d <= limit; d++) {
            // Update tight condition: stays tight if we're placing max allowed digit
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            // Recursive call for next position, updated tight and sum
            res = (res + fun(i + 1, newTight, sum + d, max_sum, min_sum, str)) % MOD;
        }

        // Store result in DP table
        return dp[i][tight][sum][0] = res;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        // Count all good numbers <= num2
        dp = new Integer[23][2][401][1];  // max 22 digits, digit sum ≤ 9*22 ≈ 198
        int to = fun(0, 1, 0, max_sum, min_sum, num2);

        // Count all good numbers < num1
        dp = new Integer[23][2][401][1];
        int from = fun(0, 1, 0, max_sum, min_sum, num1);

        // Check if num1 itself is a good number
        int sum1 = 0;
        for (char c : num1.toCharArray()) sum1 += c - '0';
        int include = (sum1 >= min_sum && sum1 <= max_sum) ? 1 : 0;

        // Final result = count(num1..num2) = to - from + include
        // Add MOD before modulo to avoid negative result
        return ((to - from + include + MOD) % MOD);
    }
}
