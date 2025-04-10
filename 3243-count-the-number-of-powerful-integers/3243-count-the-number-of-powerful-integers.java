import java.util.Arrays;

class Solution {
    String numStr;    // String representation of N for count(N)
    int limit;
    String suffix;
    int suffixLen;
    int len;          // Length of numStr
    Long[][][] memo; // Memoization table: index, isTight, isLeadingZero

    // DP function: Counts valid number endings from index onwards
    long dp(int index, boolean isTight, boolean isLeadingZero) {
        // Base case: Reached the end of the number length
        if (index == len) {
            // If we are still in leading zero state, it means we formed 0.
            // We count only non-zero numbers formed.
            return isLeadingZero ? 0 : 1;
        }

        // Check memoization table
        if (memo[index][isTight ? 1 : 0][isLeadingZero ? 1 : 0] != null) {
            return memo[index][isTight ? 1 : 0][isLeadingZero ? 1 : 0];
        }

        long count = 0;
        // Determine the upper bound for the current digit
        int upperBound = isTight ? (numStr.charAt(index) - '0') : 9;
        // Calculate where the prefix part ends (exclusive) / suffix part starts (inclusive)
        int suffixStartIndex = len - suffixLen;

        for (int digit = 0; digit <= upperBound; digit++) {
            // Check if the current digit maintains the leading zero state
            boolean currentLeading = isLeadingZero && (digit == 0);

            // --- Apply Constraints ---

            // 1. Prefix Constraint: If in prefix AND not leading zero AND digit exceeds limit
            if (index < suffixStartIndex && !currentLeading && digit > limit) {
                continue; // Skip this invalid digit
            }

            // 2. Suffix Constraint: If in suffix part, digit must match suffix
            if (index >= suffixStartIndex) {
                int suffixCharIndex = index - suffixStartIndex;
                int requiredSuffixDigit = suffix.charAt(suffixCharIndex) - '0';
                if (digit != requiredSuffixDigit) {
                    continue; // Skip this invalid digit
                }
            }

            // --- Constraints passed, make recursive call ---

            // Calculate the tightness for the next state
            boolean newTight = isTight && (digit == upperBound);
            // Add the count from the recursive call
            count += dp(index + 1, newTight, currentLeading);
        }

        // Store result in memo table and return
        memo[index][isTight ? 1 : 0][isLeadingZero ? 1 : 0] = count;
        return count;
    }

    // Calculates count of powerful integers in (0, N]
    long countPowerfulUpTo(long N) {
        if (N < 0) return 0; // Handle negative input if necessary

        numStr = Long.toString(N);
        len = numStr.length();

        // If N is shorter than the suffix string, no powerful int <= N is possible
        if (len < suffixLen) {
            return 0;
        }
        
        // Check if N itself is smaller than the suffix value *numerically*.
        // This handles cases like N=80, s="95". Although len >= suffixLen, 80 < 95.
        // Only needed if suffix can represent a value larger than N despite length constraints.
        try {
            long suffixVal = Long.parseLong(suffix);
             // If N is strictly less than the suffix value, it can't end with the suffix.
            // (Unless suffix is "0" and N is 0, special case if 0 counts).
            if (N < suffixVal && suffixVal != 0) { // Avoid issue if suffix is "0"
                 return 0;
            }
        } catch (NumberFormatException e) {
            // Suffix too long for long? Assume valid per constraints or handle error.
             return 0; // Or throw error based on expected constraints
        }


        // Initialize memoization table (size len+1 for base case index)
        memo = new Long[len + 1][2][2];

        // Start DP: index 0, tight constraint active, initially leading zero state
        return dp(0, true, true);
    }


    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.limit = limit;
        this.suffix = s;

        // Basic validation
        if (s == null || s.isEmpty()) {
             return 0; // Cannot have an empty suffix? Define behavior.
        }
        this.suffixLen = s.length();


        // Calculate count up to finish and subtract count up to start - 1
        long countFinish = countPowerfulUpTo(finish);
        long countStartMinus1 = countPowerfulUpTo(start - 1);

        return countFinish - countStartMinus1;
    }
}