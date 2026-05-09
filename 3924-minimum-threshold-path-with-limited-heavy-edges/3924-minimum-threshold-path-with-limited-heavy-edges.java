class Solution {

    public boolean path(int n, int source, int target,
                        int k, int th,
                        List<List<int[]>> adj) {

        Queue<int[]> q = new ArrayDeque<>();

        // vis[node] = minimum heavy edges used to reach node
        
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);

        q.offer(new int[]{source, 0});
        vis[source] = 0;

        while (!q.isEmpty()) {

            int[] arr = q.poll();

            int node = arr[0];
            int he = arr[1];

            if (node == target) return true;

            for (int[] anode : adj.get(node)) {

                int adjNode = anode[0];
                int cw = anode[1];

                int newHeavy = he;

                if (cw > th) {
                    newHeavy++;
                }

                if (newHeavy <= k && newHeavy < vis[adjNode]) {

                    vis[adjNode] = newHeavy;

                    q.offer(new int[]{adjNode, newHeavy});
                }
            }
        }

        return false;
    }

    public int minimumThreshold(int n, int[][] edges,
                                int source, int target, int k) {

        if (source == target) {
            return 0;
        }

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ed : edges) {

            int u = ed[0];
            int v = ed[1];
            int w = ed[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int l = 0;
        int h = 1_000_000_000;

        int ans = -1;

        while (l <= h) {

            int m = l + (h - l) / 2;

            boolean val = path(n, source, target, k, m, adj);

            if (val) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}