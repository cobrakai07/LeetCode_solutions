class Solution {
    int[] dirX = { 0, 0, -1, 1 };
    int[] dirY = { 1, -1, 0, 0 };

    public void dfs(int x, int y, boolean [][]safe,  int[][]arr){
        if(safe[x][y])return;
        safe[x][y]=true;
        
        for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length &&arr[nx][ny]==1) {
                    dfs(nx,ny,safe,arr);
            }
        }
    }
    public int solve(int[][] board) {
        boolean [][]safe = new boolean[board.length][board[0].length];
        for(int i1=0,i2= board.length-1,j=0;j<board[0].length;j++){
            if(board[i1][j]==1)dfs(i1,j,safe,board);
            if(board[i2][j]==1)dfs(i2,j,safe,board);
        }
        for(int i1=0,i2= board[0].length-1,j=0;j<board.length;j++){
            if(board[j][i1]==1)dfs(j,i1,safe,board);
            if(board[j][i2]==1)dfs(j,i2,safe,board);
        }

        int count = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(!safe[i][j] && board[i][j]==1)
                    count++;
            }
        }

        return count;
    }
    public int numEnclaves(int[][] grid) {
        return solve(grid);
    }
}