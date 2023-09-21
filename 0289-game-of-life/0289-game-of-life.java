class Solution {
    public int fun(int x, int y, int[][]grid)
    {
        int c=0;

        if(x+1<grid.length)//down
        {
            if(grid[x+1][y]==1)
            c++;
        }
        if(x-1>=0)//up
        {
            if(grid[x-1][y]==1)
            c++;
        }
        if(y+1<grid[0].length)//right
        {
            if(grid[x][y+1]==1)
            c++;
        }
        if(y-1>=0)//left
        {
            if(grid[x][y-1]==1)
            c++;
        }

        if(x+1<grid.length&&y-1>=0)//down left
        {
            if(grid[x+1][y-1]==1)
            c++;
        }
         if(x+1<grid.length&&y+1<grid[0].length)//down right
        {
            if(grid[x+1][y+1]==1)
            c++;
        }
        if(x-1>=0&&y-1>=0)//up left
        {
            if(grid[x-1][y-1]==1)
            c++;
        }
        if(x-1>=0&&y+1<grid[0].length)//up left
        {
            if(grid[x-1][y+1]==1)
            c++;
        }
        return c;
        
    }
    public void gameOfLife(int[][] board) {
        int [][]state=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                state[i][j]=fun(i,j,board);
            }
        }

        int [][]ans=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==1&&state[i][j]<2)
                {
                    ans[i][j]=0;
                }
                else if(board[i][j]==1&&state[i][j]>=2&&state[i][j]<4)
                {
                    ans[i][j]=1;
                }
                else if(board[i][j]==1&&state[i][j]>3)
                {
                    ans[i][j]=0;
                }
                else if(board[i][j]==0&&state[i][j]==3)
                {
                    ans[i][j]=1;
                }
            }
        }

         for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]=ans[i][j];
            }
        }
    }
}