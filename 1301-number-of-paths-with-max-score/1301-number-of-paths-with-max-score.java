class Solution {

    public static final int MOD = 1_000_000_007;

    public int max(int i, int j, char[][] grid, int[][] dp){
        if(i == 0 && j == 0) return 0;
        
        if(i<0 || j<0 || grid[i][j]=='X') return Integer.MIN_VALUE/2;

        if(dp[i][j]!=-1)return dp[i][j];

        int num = grid[i][j]!='S'?grid[i][j]-'0':0;

        int left = 0, up = 0, upLeft = 0;

        up = num + max(i-1,j,grid,dp);
        left = num + max(i,j-1,grid,dp);
        upLeft = num + max(i-1,j-1,grid,dp);

        return dp[i][j] = Math.max(up,Math.max(left,upLeft));
    }
    public int ways(int i, int j, int sum ,char[][] grid, int[][][]dp){
        if(i == 0 && j == 0 && sum ==0 ) return 1;
        if( i==0 && j== 0)return 0;
        if(i<0 || j<0 || grid[i][j]=='X') return 0;

        if(dp[i][j][sum]!=-1)return dp[i][j][sum];

        int num = grid[i][j]!='S'?grid[i][j]-'0':0;

        int left = 0, up = 0, upLeft = 0;

        up =  ways(i-1,j,sum-num,grid,dp);
        left = ways(i,j-1,sum-num,grid,dp);
        upLeft = ways(i-1,j-1,sum-num,grid,dp);

        int first = ((up % MOD) + (left % MOD))% MOD;
        int total = ((first % MOD) + (upLeft % MOD))% MOD;
        return dp[i][j][sum] = total;
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] grid = new char[n][n];

        for(int i=0;i<n;i++){
            String s = board.get(i);
            for(int j=0;j<n;j++){
                grid[i][j]=s.charAt(j);
            }
        }

        int[][] dp = new int[n][n];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        int sum = max(n-1,n-1,grid,dp);
        if(sum<0)return new int[]{0,0};

        int[][][] dpp = new int[n][n][n*18];
        for(int [][]a: dpp){
            for(int []b: a)
                Arrays.fill(b,-1);
        }
        int totalWays = ways(n-1,n-1,sum,grid,dpp);

        // System.out.println(sum);

        return new int[]{sum,totalWays};

    }
}