class Solution {
  int peri=0;
    public void fun(int idx,int idy,int[][]visited,int[][]grid)
    {
      if(visited[idx][idy]==1)
         return;
      
      visited[idx][idy]=1;

      if(idx-1>=0&&grid[idx-1][idy]==1&&visited[idx-1][idy]!=1)
      {
        fun(idx-1,idy,visited,grid);
      }
      else
      {
        if(idx-1<0||grid[idx-1][idy]!=1)
        peri++;
      }
      if(idx+1<grid.length&&grid[idx+1][idy]==1&&visited[idx+1][idy]!=1)
      {
        fun(idx+1,idy,visited,grid);
      }
      else
      {
       if(idx+1>=grid.length||grid[idx+1][idy]!=1)
        peri++;
      }
      if(idy-1>=0&&grid[idx][idy-1]==1&&visited[idx][idy-1]!=1)
      {
        fun(idx,idy-1,visited,grid);
      }
      else
      {
        if(idy-1<0||grid[idx][idy-1]!=1)
        peri++;
      }
      if(idy+1<grid[0].length&&grid[idx][idy+1]==1&&visited[idx][idy+1]!=1)
      {
        fun(idx,idy+1,visited,grid);
      }
      else
      {
        if(idy+1>=grid[0].length||grid[idx][idy+1]!=1)
        peri++;
      }
    }
    public int islandPerimeter(int[][] grid) {
      int totalPeri=0;
      boolean flag1=false;
      boolean flag2=false;
      int x=-1,y=-1;
        for(int i=0;i<grid.length;i++)
        {
          for(int j=0;j<grid[0].length;j++)
          {
            if(grid[i][j]==1)
            {
              if(!flag1)
              {
                x=i;
                y=j;
                flag1=true;
              }

              totalPeri+=4;
            }
            else
            {
              if(!flag2)
              {
                flag2=true;
              }
            }
          }
        }
        if(!flag2)
        {
          return (2*(grid.length+grid[0].length));
        }
      int visited[][]= new int [grid.length][grid[0].length];
      fun(x,y,visited,grid);
      return peri;
      
    }
}