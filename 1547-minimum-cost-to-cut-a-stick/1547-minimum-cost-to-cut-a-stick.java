class Solution {
    int[][] dp;

    public int solve(int i, int j, int[] cuts) {
        if (j - i <= 1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int cost = (cuts[j] - cuts[i])
                    + solve(i, k, cuts)
                    + solve(k, j, cuts);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];

        newCuts[0] = 0;
        newCuts[m + 1] = n;

        Arrays.sort(cuts);
        for (int i = 0; i < m; i++)
            newCuts[i + 1] = cuts[i];

        dp = new int[m + 2][m + 2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, m + 1, newCuts);
    }
}