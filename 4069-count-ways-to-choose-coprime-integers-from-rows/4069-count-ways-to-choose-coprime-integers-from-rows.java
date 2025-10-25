class Solution {
    int mod = 1_000_000_007;

    int findgcd(int n, int m) {
        while (n != 0 && m != 0) {
            if (n > m)
                n = n % m;
            else
                m = m % n;
        }
        return n == 0 ? m : n;
    }

    int fun(int i, int gcd, int[][] mat, int[][] dp) {
        if (i == mat.length) {
            return gcd == 1 ? 1 : 0;
        }
        if (dp[i][gcd+1] != -1)
            return dp[i][gcd+1];
        int total = 0;
        if (gcd == -1) {
            for (int it = 0; it < mat[0].length; it++) {

                total = (total + fun(i + 1, mat[i][it], mat, dp)) % mod;
            }
        } else {
            for (int it = 0; it < mat[i].length; it++) {
                int gcdCal = findgcd(gcd, mat[i][it]);

                total = (total + fun(i + 1, gcdCal, mat, dp)) % mod;

            }
        }
        return dp[i][gcd+1] = total % mod;
    }

    public int countCoprime(int[][] mat) {
        int[][] dp = new int[mat.length + 1][152];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return fun(0, -1, mat, dp);
    }
}