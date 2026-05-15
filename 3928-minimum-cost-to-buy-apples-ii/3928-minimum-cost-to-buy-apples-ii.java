class Solution {
    List<List<int[]>> adj;
    int[] prices;
    int n;

    public int[] minCost(int n, int[] prices, int[][] roads) {
        this.n = n;
        this.prices = prices;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], c = r[2], t = r[3];
            adj.get(u).add(new int[]{v, c, t});
            adj.get(v).add(new int[]{u, c, t});
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long[] de = dijkstra(i, false);  
            long[] dl = dijkstra(i, true);    
            long best = prices[i];
            for (int j = 0; j < n; j++) {
                if (de[j] == Long.MAX_VALUE || dl[j] == Long.MAX_VALUE) continue;
                best = Math.min(best, (long) prices[j] + de[j] + dl[j]);
            }
            ans[i] = (int) best;
        }
        return ans;
    }

    public long[] dijkstra(int src, boolean loaded) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );
        pq.offer(new long[]{src, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];
            if (d > dist[u]) continue;

            for (int[] e : adj.get(u)) {
                int v = e[0], c = e[1], t = e[2];
                long w = loaded ? (long) c * t : c;   
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }
        return dist;
    }
}

