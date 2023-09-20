class Pair{
    int row;
    int col;
    int time;

    Pair(int row,int col,int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {

        int visited[][]=new int[grid.length][grid[0].length];
        Queue<Pair>q=new ArrayDeque<>();

        int freshOrangesBefore=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else
                {
                    visited[i][j]=0;
                }

                if(grid[i][j]==1)
                  freshOrangesBefore++;
            }
        }

        int ansTime=0;
        int freshOrangesAfter=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair ptemp=q.poll();
            
            for(int i=0;i<drow.length;i++)
            {
                int ncol=ptemp.col+drow[i];
                int nrow=ptemp.row+dcol[i];
                ansTime=Math.max(ansTime,ptemp.time);

                if(ncol<grid[0].length&&ncol>=0&&nrow<grid.length&&nrow>=0 && visited[nrow][ncol]==0 &&grid[nrow][ncol]==1)
                {
                    q.offer(new Pair(nrow,ncol,ptemp.time+1));
                    visited[nrow][ncol]=2;
                    freshOrangesAfter++;

                }
            }
        }

        if(freshOrangesAfter!=freshOrangesBefore)return -1;//no of rotten oranges after is equal to no of fresh oranges before

        return ansTime;

        
    }
}