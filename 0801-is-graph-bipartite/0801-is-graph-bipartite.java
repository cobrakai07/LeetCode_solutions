class Solution {
    public boolean fun(int node, int[][]graph, int[]color){

        for(int i=0;i<graph[node].length;i++){
            if(color[ graph[node][i] ]==-1){
                color[graph[node][i]] = color[node]==1 ? 2: 1;
                if(!fun(graph[node][i],graph,color))return false;
            }else{
                if(color[graph[node][i]] == color[node])return false;
            }
        }
        
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[]color= new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!fun(i,graph,color))return false;
            }
        }
        return true;
    }
}