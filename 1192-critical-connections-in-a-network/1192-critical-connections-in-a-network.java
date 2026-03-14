class Solution {

    int timer = 0;
    List<List<Integer>> bridges = new ArrayList<>();

    public void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> adj){

        vis[node] = true;
        tin[node] = low[node] = timer++;

        for(int nei : adj.get(node)){

            if(nei == parent) continue;

            if(!vis[nei]){

                dfs(nei, node, vis, tin, low, adj);

                low[node] = Math.min(low[node], low[nei]);

                if(low[nei] > tin[node]){
                    bridges.add(Arrays.asList(node, nei));
                }

            } 
            else{
                low[node] = Math.min(low[node], tin[nei]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(List<Integer> e : connections){
            int u = e.get(0);
            int v = e.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        dfs(0,-1,vis,tin,low,adj);

        return bridges;
    }
}