class Solution {
    public static int MOD = 1000_000_007;
    public int fun(int dir,int i, int j, int m, int n, int[][] grid, Integer[][][]dp){
        // System.out.println(i+","+j);
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(i<0 ||j<0 ||i>=m ||j>=n){
            return 0;
        }

        if(dp[dir][i][j]!=null) return dp[dir][i][j];

        int right = 0 , down =0;

        if(grid[i][j]==1){
            if(dir==0){
                down=(down+fun(1,i+1,j,m,n,grid,dp))%MOD;
            }else{
                right= (right+fun(0,i,j+1,m,n,grid,dp))%MOD;
            }
        }else{
            down= (down + fun(1,i+1,j,m,n,grid,dp))%MOD;
            right= (right + fun(0,i,j+1,m,n,grid,dp))%MOD;
        }

        return dp[dir][i][j]=(down+right)%MOD;

    }
    public int uniquePaths(int[][] grid) {
        Integer[][][]dp = new Integer[2][501][501];
        return fun(0,0,0, grid.length, grid[0].length,grid,dp);
    }
}