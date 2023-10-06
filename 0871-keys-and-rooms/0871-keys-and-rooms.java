class Solution {
    public void fun(int idx,List<List<Integer>> rooms,int[] visited)
    {
        if(visited[idx]==1)return;
        visited[idx]=1;
        List<Integer>list=rooms.get(idx);
        for(int x: list)
        {
            if(visited[x]==0)
            {
                fun(x,rooms,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int visited[]=new int[rooms.size()];
        fun(0,rooms,visited);
        for(int x: visited)
        {
            if(x==0)return false;
        }
        return true;
    }
}