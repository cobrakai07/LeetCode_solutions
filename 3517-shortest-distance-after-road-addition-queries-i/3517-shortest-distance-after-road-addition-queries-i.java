class Solution {
    public int dij(int s, int[][] g) {
        int n = g.length;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{s, 0});
        
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int u = t[0], d = t[1];
            if (d > dis[u]) continue;
            
            for (int v = 0; v < n; v++) {
                if (g[u][v] != 0) {
                    int newDist = dis[u] + g[u][v];
                    if (newDist < dis[v]) {
                        dis[v] = newDist;
                        pq.offer(new int[]{v, newDist});
                    }
                }
            }
        }
        return dis[n - 1] ;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[][] graph = new int[n][n];
        for (int i = 0, j = 1; i < n - 1; i++, j++) {
            graph[i][j] = 1;
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] a : queries) {
            graph[a[0]][a[1]] = 1;
            ans[idx++] = dij(0, graph);
        }
        return ans;
    }
    
}
