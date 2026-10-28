class Solution {
    public int fun(int i, int j, int xor, int[][]arr,int [][][] dp){
        if(i==arr.length -1 && j == arr[0].length-1){
            return xor^ arr[i][j];
        }

        if(i==arr.length  ||j == arr[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j][xor]!= Integer.MAX_VALUE)return dp[i][j][xor];

        int down = fun(i+1,j,arr[i][j]^xor,arr,dp);
        int right = fun(i,j+1,arr[i][j]^xor,arr,dp);

        return dp[i][j][xor] = Math.min(down,right);
    }
    public int minCost(int[][] grid) {
        int [][][] dp = new int[grid.length][grid[0].length][1025];
        for(int [][] a: dp){
            for(int [] b: a)
                Arrays.fill(b,Integer.MAX_VALUE);
        }
        return fun(0,0,0,grid, dp);
    }
}