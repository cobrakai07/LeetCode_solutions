class Solution {
    public int fun(int i, int j1, int j2, int[][]arr, int[][][]dp){
        if(j1<0||j1>=arr[0].length||j2<0||j2>=arr[0].length)    return (int) (Math.pow(-10, 9));
        if(i==arr.length-1){
            if(j1==j2)return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }
        
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];

        int max=Integer.MIN_VALUE;
        for(int k1=-1;k1<=1;k1++){
            for(int k2=-1;k2<=1;k2++){
                if(j1==j2)
                    max= Math.max(max, arr[i][j1] + fun(i+1, j1+k1, j2+k2, arr, dp));
                else
                    max= Math.max(max, arr[i][j1] + arr[i][j2] + fun(i+1, j1+k1, j2+k2, arr, dp));
            }
        }
        return dp[i][j1][j2] = max;
    }
    public int cherryPickup(int[][] grid) {
        int[][][]dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int [][] a: dp){
            for(int []b: a)
                Arrays.fill(b,-1);
        }
        return fun(0,0,grid[0].length-1,grid,dp);
    }
}