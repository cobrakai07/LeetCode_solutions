class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][]dis=new int[mat.length][mat[0].length];
        int [][]visited=new int[mat.length][mat[0].length];
        Queue<Pair<Pair<Integer,Integer>,Integer>>q=new ArrayDeque<>();
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new Pair(new Pair(i,j),0));
                    visited[i][j]=1;
                }
            }
        }

        while(!q.isEmpty())
        {

           Pair<Pair<Integer,Integer>,Integer>tempPair=q.poll(); 
           Pair<Integer,Integer>coordinates=tempPair.getKey();
           int x=coordinates.getKey();
           int y=coordinates.getValue();
           int distance =tempPair.getValue();
           
           dis[x][y]= distance;
               
           if(x-1>=0&&visited[x-1][y]!=1)
           {
               visited[x-1][y]=1;
               q.offer(new Pair(new Pair(x-1,y),distance+1));
           }
            if(x+1<mat.length&&visited[x+1][y]!=1)
           {
               visited[x+1][y]=1;
               q.offer(new Pair(new Pair(x+1,y),distance+1));
           }
           if(y+1<mat[0].length&&visited[x][y+1]!=1)
           {
               visited[x][y+1]=1;
               q.offer(new Pair(new Pair(x,y+1),distance+1));
           }
           if(y-1>=0&&visited[x][y-1]!=1)
           {
               visited[x][y-1]=1;
               q.offer(new Pair(new Pair(x,y-1),distance+1));
           }
        }

        return dis;
    }
}