class Solution {
    public int fun(int i1, int j1, int i2, int j2, int[][] grid, Integer[][][][] dp) {
        int j2New = i1 + j1 - i2; // because (i1+j1) == (i2+j2) always (same number of steps)

        if (i1 >= grid.length || j1 >= grid[0].length || i2 >= grid.length || j2New >= grid[0].length ||
            grid[i1][j1] == -1 || grid[i2][j2New] == -1)
            return Integer.MIN_VALUE;
        
        if (i1 == grid.length - 1 && j1 == grid[0].length - 1)
            return grid[i1][j1];
        
        if (dp[i1][j1][i2][j2New] != null)
            return dp[i1][j1][i2][j2New];
        
        int ans = 0;
        if (i1 == i2 && j1 == j2New)
            ans += grid[i1][j1];
        else
            ans += grid[i1][j1] + grid[i2][j2New];
        
        int temp = Math.max(
            Math.max(fun(i1 + 1, j1, i2 + 1, j2, grid, dp), fun(i1, j1 + 1, i2, j2 + 1, grid, dp)),
            Math.max(fun(i1 + 1, j1, i2, j2 + 1, grid, dp), fun(i1, j1 + 1, i2 + 1, j2, grid, dp))
        );
        
        ans += temp;
        return dp[i1][j1][i2][j2New] = ans;
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Integer[][][][] dp = new Integer[n][m][n][m];
        int result = fun(0, 0, 0, 0, grid, dp);
        return Math.max(result, 0);
    }
}
