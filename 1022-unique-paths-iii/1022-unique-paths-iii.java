class Solution {
    int ans=0;
    public void fun(int x,int y,int[][]visited,int[][]grid,int blocktoCover)
    {
        if(grid[x][y]==2)
        {
            if(blocktoCover==0)
                ans++;
            return;
        }
        if(grid[x][y]==-1)
           return;

        if(x+1<grid.length&&visited[x+1][y]==0)//down
           {
               visited[x+1][y]=1;
               //
               boolean flag=false;

               if(grid[x+1][y]==2)
                   flag=true;
               else
                   blocktoCover--;

               fun(x+1,y,visited,grid,blocktoCover);
               if(!flag)
                 blocktoCover++;
               visited[x+1][y]=0;
               //
           }
        if(x-1>=0&&visited[x-1][y]==0)//up
           {
               visited[x-1][y]=1;
               //
               boolean flag=false;

               if(grid[x-1][y]==2)
                   flag=true;
               else
                   blocktoCover--;

               fun(x-1,y,visited,grid,blocktoCover);
               if(!flag)
                 blocktoCover++;
               visited[x-1][y]=0;
               //
           }
        if(y+1<grid[0].length&&visited[x][y+1]==0)//right
           {
               visited[x][y+1]=1;
                //
                boolean flag=false;

               if(grid[x][y+1]==2)
                   flag=true;
               else
                   blocktoCover--;

               fun(x,y+1,visited,grid,blocktoCover);
               if(!flag)
                 blocktoCover++;
               visited[x][y+1]=0;
               ///
           }
        if(y-1>=0&&visited[x][y-1]==0)//left
           {
               visited[x][y-1]=1;
               boolean flag=false;

               if(grid[x][y-1]==2)
                   flag=true;
               else
                   blocktoCover--;

               fun(x,y-1,visited,grid,blocktoCover);
               if(!flag)
                 blocktoCover++;
               visited[x][y-1]=0;
           }
    }

    public int uniquePathsIII(int[][] grid) {
       int visited[][]=new int[grid.length][grid[0].length]; 
       int blocktoCover=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    blocktoCover++;
                }
            }
        }

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    visited[i][j]=1;
                    fun(i,j,visited,grid,blocktoCover);
                    break;
                }
            }
        }
        return ans;
    }
}