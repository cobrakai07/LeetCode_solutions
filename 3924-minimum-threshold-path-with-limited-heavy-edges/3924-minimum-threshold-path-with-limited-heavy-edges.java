class Solution {

    public boolean path(int n, int source, int target,
                        int k, int th,
                        List<List<int[]>> adj) {

        Deque<int[]> dq = new ArrayDeque<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        dq.offerFirst(new int[]{source, 0});

        while (!dq.isEmpty()) {

            int[] cur = dq.pollFirst();

            int node = cur[0];
            int heavy = cur[1];

            if (node == target) {
                return true;
            }

            for (int[] nei : adj.get(node)) {

                int next = nei[0];
                int w = nei[1];

                int newHeavy = heavy + (w > th ? 1 : 0);

                if (newHeavy < dist[next] && newHeavy <= k) {

                    dist[next] = newHeavy;

                    if (w > th) {
                        dq.offerLast(new int[]{next, newHeavy});
                    } else {
                        dq.offerFirst(new int[]{next, newHeavy});
                    }
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

            int mid = l + (h - l) / 2;

            if (path(n, source, target, k, mid, adj)) {

                ans = mid;
                h = mid - 1;

            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}