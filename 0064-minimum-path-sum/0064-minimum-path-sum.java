class Solution {
    public int fun(int i, int j, int[][]grid, int[][]dp){
        if(i==grid.length-1 && j==grid[0].length-1)
            return grid[i][j];
        if(i==grid.length || j==grid[0].length)
            return 9999999;
        if(dp[i][j]!=-1)return dp[i][j];
        int right = grid[i][j]+fun(i,j+1,grid,dp);
        int down = grid[i][j]+fun(i+1,j,grid,dp);
        return dp[i][j]=Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int []a:dp)Arrays.fill(a,-1);
        return fun(0,0,grid,dp);
    }
}