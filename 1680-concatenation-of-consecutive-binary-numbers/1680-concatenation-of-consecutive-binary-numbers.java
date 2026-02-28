class Solution {
    public static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long ans = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            ans = ((ans << bitLength) + i) % MOD;
        }

        return (int) ans;
    }
}