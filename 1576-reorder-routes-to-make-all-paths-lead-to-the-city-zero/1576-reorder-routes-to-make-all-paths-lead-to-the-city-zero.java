class Solution {
    int turn = 0;
    
    public void dfs(int node, boolean[] vis, List<List<int[]>> adj) {
        vis[node] = true;
        
        for (int[] neighbor : adj.get(node)) {
            int nextNode = neighbor[0];
            int direction = neighbor[1];
            
            if (!vis[nextNode]) {
                if (direction == 1) {
                    turn++;
                }
                dfs(nextNode, vis, adj);
            }
        }
    }
    
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        

        for (int[] conn : connections) {
            adj.get(conn[0]).add(new int[]{conn[1], 1}); 
            adj.get(conn[1]).add(new int[]{conn[0], -1});
        }
        
        boolean[] vis = new boolean[n];
        dfs(0, vis, adj);
        
        return turn;
    }
}
