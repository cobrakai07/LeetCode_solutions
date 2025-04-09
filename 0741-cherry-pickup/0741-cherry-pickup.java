class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        return Math.max(0, dfs(0, 0, 0, grid, dp));
    }

    // r1, c1 = person1's position
    // r2 = person2's row, c2 = derived
    private int dfs(int r1, int c1, int r2, int[][] grid, Integer[][][] dp) {
        int c2 = r1 + c1 - r2; // because r1 + c1 == r2 + c2 at the same time
        int n = grid.length;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];

        if (dp[r1][c1][r2] != null) return dp[r1][c1][r2];

        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        int max = Math.max(
            Math.max(dfs(r1 + 1, c1, r2 + 1, grid, dp), dfs(r1, c1 + 1, r2, grid, dp)),
            Math.max(dfs(r1 + 1, c1, r2, grid, dp), dfs(r1, c1 + 1, r2 + 1, grid, dp))
        );

        dp[r1][c1][r2] = cherries + max;
        return dp[r1][c1][r2];
    }
}
