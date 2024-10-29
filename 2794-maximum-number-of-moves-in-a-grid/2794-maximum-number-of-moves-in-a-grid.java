class Solution {
    public int fun(int i, int j, int[][]dp, int[][]g){

        if(dp[i][j]!=-1)return dp[i][j];
        int u=0,d=0,l=0;
        if(i-1>=0 && j+1<dp[0].length && g[i][j]<g[i-1][j+1]){
            u=1+fun(i-1,j+1,dp,g);
        }
        if(i+1<g.length && j+1<dp[0].length && g[i][j]<g[i+1][j+1]){
            d=1+fun(i+1,j+1,dp,g);
        }
        if(j+1<dp[0].length && g[i][j]<g[i][j+1]){
            l=1+fun(i,j+1,dp,g);
        }

        return dp[i][j]=Math.max(u,Math.max(l,d));
    }
    public int maxMoves(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int i[]: dp)Arrays.fill(i,-1);
        int max=-1;
        for(int i=0,j=0; i<grid.length ;i++){
            max=Math.max(fun(i,j,dp,grid),max);
        }
        return max;
    }
}