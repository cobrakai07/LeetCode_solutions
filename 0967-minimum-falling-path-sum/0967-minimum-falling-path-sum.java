class Solution {
    public int fun(int i,int j, int[][]arr, int[][]dp){
      
        if(i==arr.length)return 0;
        if(j<0||j==arr[0].length)return 1111111;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
      
        int rd=arr[i][j]+fun(i+1,j+1,arr,dp);
        int ld=arr[i][j]+fun(i+1,j-1,arr,dp);
        int d=arr[i][j]+fun(i+1,j,arr,dp);

        return dp[i][j]= Math.min(rd,Math.min(ld,d)); 
    }
    public int minFallingPathSum(int[][] matrix) {
        int[][]dp =new int[matrix.length][matrix[0].length];
        for(int[]a:dp)Arrays.fill(a,Integer.MAX_VALUE);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(min, fun(0,i,matrix,dp));
        }
        return min;
    }
}