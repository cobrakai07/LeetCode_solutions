class Solution {
    public boolean fun(int node, int[]vis, int[]pathVis,int[] isNotSafe, int[][]graph){
        vis[node]=1;
        pathVis[node]=1;

        for(int i: graph[node]){
            if(vis[i]==0 && fun(i, vis, pathVis,isNotSafe, graph)){
                isNotSafe[node]=1;
                return true;
            }else if(pathVis[i]==1){
                isNotSafe[node]=1;
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[]vis= new int[graph.length];
        int[]pathVis= new int[graph.length];
        int[]isNotSafe= new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(vis[i]==0)
                fun(i,vis,pathVis,isNotSafe,graph);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(isNotSafe[i]==0)list.add(i);
        }
        // System.out.println(Arrays.toString(isNotSafe));
        return list;
    }
}