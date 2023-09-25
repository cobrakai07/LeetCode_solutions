class Solution {
    int maxGold=0;

    public int getMaximumGold(int[][] grid) {

        int[][]vis=new int[grid.length][grid[0].length];

        //when no zero.....
        int sum=0;
        boolean flag=false;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                sum+=grid[i][j];
                if(grid[i][j]==0)
                   flag=true;
            }
        }

        if(!flag)return sum;
        //.........

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    vis[i][j]=1;
                    fun(i,j,vis,grid,grid[i][j]);
                    vis[i][j]=0;
                }
            }
        }
        return maxGold;
    }

    ///
    public void fun(int x,int y,int[][]visited,int[][]grid,int gold)
    {
        if(grid[x][y]==0)
        {
           
            if(gold>maxGold)
                maxGold=gold;
            return;
        }
        

        if(x+1<grid.length&&visited[x+1][y]==0)//down
           {
               visited[x+1][y]=1;
               fun(x+1,y,visited,grid,gold+grid[x+1][y]);
               visited[x+1][y]=0;
               //
           }
        if(x-1>=0&&visited[x-1][y]==0)//up
           {
               visited[x-1][y]=1;
               fun(x-1,y,visited,grid,gold+grid[x-1][y]);
               visited[x-1][y]=0;
               //
           }
        if(y+1<grid[0].length&&visited[x][y+1]==0)//right
           {
               visited[x][y+1]=1;
               fun(x,y+1,visited,grid,gold+grid[x][y+1]);
               visited[x][y+1]=0;
               ///
           }
        if(y-1>=0&&visited[x][y-1]==0)//left
           {
               visited[x][y-1]=1;
               fun(x,y-1,visited,grid,gold+grid[x][y-1]);
               visited[x][y-1]=0;
           }
    }
    ///
}