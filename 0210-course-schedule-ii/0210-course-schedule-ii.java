
class Solution {
    public boolean dfs(int node, int[] vis, int[] pathVis, List<List<Integer>> adj, Stack<Integer> stk) {
        vis[node] = 1;
        pathVis[node] = 1; 
        
        for (int i : adj.get(node)) {
            if (pathVis[i] == 1) return false;
            if (vis[i] == 0) {
                if (!dfs(i, vis, pathVis, adj, stk)) return false;
            }
        }
        
        pathVis[node] = 0; 
        stk.push(node);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] i : prerequisites) {
            int from = i[0], to = i[1];
            adj.get(to).add(from);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, vis, pathVis, adj, stk)) return new int[] {};
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while (!stk.isEmpty()) ans[i++] = stk.pop();
        
        return ans; 
    }
}
