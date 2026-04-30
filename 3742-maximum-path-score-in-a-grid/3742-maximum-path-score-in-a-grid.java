class Solution {
    public int fun(int i, int j , int cost, int k, int [][]grid, int[][][]dp){
        if(i>=grid.length || j>=grid[0].length){
            return -99999;
        }
        if(cost>k)return -99999;
        if(i==grid.length-1 && j==grid[0].length-1){
            int ccost = grid[i][j]==0?0:1;
            if(cost+ccost>k)return -99999;
            return grid[i][j];
        }
        if(dp[i][j][cost]!=-1)return dp[i][j][cost];

        int rr = 0, dd= 0;
        int ccost = grid[i][j]==0?0:1;
        rr = grid[i][j]+ fun(i,j+1, cost+ccost, k, grid, dp);
        dd = grid[i][j]+ fun(i+1,j, cost+ccost, k, grid, dp);

        return dp[i][j][cost]=Math.max(rr,dd);
    }
    public int maxPathScore(int[][] grid, int k) {
        int[][][]dp = new int[grid.length][grid[0].length][402];
        for(int [][]aa: dp){
            for(int a[]: aa){
                Arrays.fill(a,-1);
            }
        }
        int ans = fun(0,0,0,k,grid,dp);
        return ans<0?-1:ans;
    }
}