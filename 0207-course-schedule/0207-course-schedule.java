class Solution {
    public boolean dfs(int node , int[]vis,int[] pathVis,List<List<Integer>>adj){
        vis[node]=1;
        pathVis[node]=1;
        for(int i : adj.get(node)){
            if(vis[i]==0 &&dfs(i,vis,pathVis,adj))
                return true;
            else if(pathVis[i]==1)
                return true;
        }
        pathVis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj= new ArrayList<>();
        int []vis= new int[numCourses];
        int []pathVis= new int[numCourses];
        for(int i: vis)adj.add(new ArrayList<>());
        for(int []i:prerequisites){
            int from = i[0], to = i[1];
            adj.get(to).add(from);
        }
        // ArrayDeque<Integer>stk = new ArrayDeque<>();

        for(int i=0;i<vis.length;i++){
            if(vis[i]==0 &&dfs(i,vis,pathVis,adj))
                return false;
        }
        return true;
    }
}