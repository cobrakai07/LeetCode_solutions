class Solution {
    private boolean dfs(int node,int[]vis,int[]pathVis,int [][]grid)
    {
       
        vis[node]=1;
        pathVis[node]=1;

            int []arr=grid[node];
            for(int i=0;i<arr.length;i++)
            {
                if(vis[arr[i]]==0)
                {
                    if(dfs(arr[i],vis,pathVis,grid))
                      return true;
                }
                else if(pathVis[arr[i]]==1)
                {
                    return true;
                }
            }
          
        pathVis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[]vis=new int [graph.length];
        int []pathVis=new int [graph.length];
        List<Integer>ans=new ArrayList<>();
       
        for(int i=0;i<graph.length;i++)  //we need to check from every node 
            dfs(i,vis,pathVis,graph);
        
         for(int i=0;i<graph.length;i++)
            {
                if(pathVis[i]==0)//means no cycle from this node
                   ans.add(i);
            }

         return ans;
    }
}