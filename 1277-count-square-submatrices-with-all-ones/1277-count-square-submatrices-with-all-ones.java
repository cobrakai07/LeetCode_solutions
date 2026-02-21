class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int [] dx ={-1,0,-1};
        int [] dy ={-1,-1,0};

        for(int i= 0; i<m; i++){
            if(matrix[i][0]==1)dp[i][0]=1;
        }
        for(int i= 0; i<n; i++){
            if(matrix[0][i]==1)dp[0][i]=1;
        }

        for(int i=1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j]==1){
                    int min = Integer.MAX_VALUE;
                    for(int k=0;k<3;k++){
                    int ni = i+dx[k];
                    int nj = j+dy[k];
                    min = Math.min(min,dp[ni][nj]);
                    }

                    dp[i][j] = min+1;
                }
            }
        }

        int total= 0;
        for(int[] d: dp){
            for(int a: d){
                total += a;
            }
        }

        return total;
    }
}