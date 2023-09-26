class Solution {

    public boolean isCoveredWithX(HashSet<Pair<Integer,Integer>>set,char[][]grid)
    {
        for(int i=0;i<grid[0].length;i++)
        {
            Pair<Integer,Integer>temp=new Pair(0,i);
            if(set.contains(temp))return false;
        }

         for(int i=0;i<grid.length;i++)
        {
            Pair<Integer,Integer>temp=new Pair(i,0);
            if(set.contains(temp))return false;
        }

        for(int i=0;i<grid[0].length;i++)
        {
            Pair<Integer,Integer>temp=new Pair(grid.length-1,i);
            if(set.contains(temp))return false;
        }

         for(int i=0;i<grid.length;i++)
        {
            Pair<Integer,Integer>temp=new Pair(i,grid[0].length-1);
            if(set.contains(temp))return false;
        }

        return true;
    }

    public void fillRegion(HashSet<Pair<Integer,Integer>>set,char[][]grid)
    {
        Iterator<Pair<Integer,Integer>> it = set.iterator();

        while (it.hasNext()) 
        {
        Pair<Integer,Integer> idx = it.next();
        grid[idx.getKey()][idx.getValue()]='X';
        }
    }

    public void infectedRegionCounter(int idx,int idy,int[][]visited,char [][]grid,HashSet<Pair<Integer,Integer>>set)//
    {
        if(visited[idx][idy]==1)return;

        visited[idx][idy]=1;
        set.add(new Pair(idx,idy));

        if(idx-1>=0&&grid[idx-1][idy]=='O')
        {
            infectedRegionCounter(idx-1,idy,visited,grid,set);
        }
        if(idx+1<grid.length&&grid[idx+1][idy]=='O')
        {
            infectedRegionCounter(idx+1,idy,visited,grid,set);
        }
        if(idy-1>=0&&grid[idx][idy-1]=='O')
        {
            infectedRegionCounter(idx,idy-1,visited,grid,set);
        }
        if(idy+1<grid[0].length&&grid[idx][idy+1]=='O')
        {
            infectedRegionCounter(idx,idy+1,visited,grid,set);
        }

    }

    public void solve(char[][] board) {
        int[][]visited=new int [board.length][board[0].length];
        HashMap<HashSet<Pair<Integer,Integer>>,Integer>setOfRegions=new HashMap<>();

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='X')
                {
                    visited[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O')
                {
                    HashSet<Pair<Integer,Integer>>set=new HashSet<>();
                    infectedRegionCounter(i,j,visited,board,set);
                    if(set.size()!=0)
                    setOfRegions.put(set,1);
                }
            }
        }


       for(HashSet<Pair<Integer,Integer>>key: setOfRegions.keySet() )
       {
           if(isCoveredWithX(key,board))
             fillRegion(key,board);
       }
    }
}