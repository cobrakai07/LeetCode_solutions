class Solution {
    int[][] dp;
    int n;

    public int solve(int i, int j, int[] cuts) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

    
        int leftBoundary = (i == 0) ? 0 : cuts[i - 1];
        int rightBoundary = (j == cuts.length - 1) ? n : cuts[j + 1];

        for (int k = i; k <= j; k++) {

            int cost = (rightBoundary - leftBoundary)
                     + solve(i, k - 1, cuts)
                     + solve(k + 1, j, cuts);

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        this.n = n;
        Arrays.sort(cuts);

        int m = cuts.length;
        dp = new int[m][m];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, m - 1, cuts);
    }
}