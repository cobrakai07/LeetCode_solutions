class Pair
{
    int x,y;
    public Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    int n,m,n1,m1;
    public int bfs2(int[][] grid1, int[][] grid2,int[][] vis_grid2,int r,int c)
    {
        int val=0;
        vis_grid2[r][c]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        int[] del_row={0,1,0,-1};
        int[] del_col={-1,0,1,0};

        while(!q.isEmpty())
        {
            int x=q.peek().x;
            int y=q.peek().y;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int d_row=x+del_row[i];
                int d_col=y+del_col[i];
                if(d_row>=0 && d_row<n && d_col>=0 && d_col<m && grid2[d_row][d_col]==1 && vis_grid2[d_row][d_col]==0)
                {
                    if(grid1[d_row][d_col]==0)
                    {
                        val=1;
                    }
                    vis_grid2[d_row][d_col]=1;
                    q.add(new Pair(d_row,d_col));
                }
            }
        }
        if(val==1)
            return 0;
        else
            return 1;

    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid2.length;
        m=grid2[0].length;
        n1=grid1.length;
        m1=grid1[0].length;

        int[][] vis_grid2=new int[n][m];
        int count=0;
        Set<Pair> set_grid1=new HashSet<>();
    
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1 && grid1[i][j]==1 && vis_grid2[i][j]==0)
                {
                    int value=bfs2(grid1,grid2,vis_grid2,i,j);
                    if(value==1)
                        count++;
                }
            }
        }
        return count;
    }
}