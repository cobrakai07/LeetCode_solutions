class Solution {
    public boolean isBipartite(int[][] graph) {
        int[]colored=new int[graph.length];
        Queue<Integer>q=new ArrayDeque<>();

        for(int x=0;x<colored.length;x++)
        {
            if(colored[x]==1||colored[x]==2)continue;
            //
            q.offer(x);
            colored[x]=1;
        while(!q.isEmpty())
        {
            int idxAdjList=q.poll();
            for(int i=0;i<graph[idxAdjList].length;i++)
            {
                if(colored[graph[idxAdjList][i]]==0)
                {
                    if(colored[idxAdjList]==1)
                       colored[graph[idxAdjList][i]]=2;
                    else
                       colored[graph[idxAdjList][i]]=1;

                    q.offer(graph[idxAdjList][i]);
                }
                else
                {
                    if(colored[idxAdjList]==colored[graph[idxAdjList][i]])
                      return false;
                }
            }
        }
            //
        }
        

        return true;
    }
}


//[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]...due to this case, traverse on whole colored array
// As there can be more than one components in a graph independent of each other
