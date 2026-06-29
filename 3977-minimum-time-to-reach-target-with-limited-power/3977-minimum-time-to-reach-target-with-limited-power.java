
class Solution {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node;
        int power;
        long time;

        State(int node, int power, long time) {
            this.node = node;
            this.power = power;
            this.time = time;
        }
    }

    public long[] minTimeMaxPower(int n, int[][] edges, int power,
                                  int[] cost, int source, int target) {

        if (source == target) {
            return new long[]{0, power};
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] dis = new long[n][power + 1];

        for (long[] row : dis) {
            Arrays.fill(row, INF);
        }

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));

        dis[source][power] = 0;
        pq.offer(new State(source, power, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int node = curr.node;
            int cp = curr.power;
            long ct = curr.time;

            if (ct > dis[node][cp]) continue;


            if (cp < cost[node]) continue;

            int newPower = cp - cost[node];

            for (Edge edge : adj.get(node)) {
                int next = edge.to;
                long newTime = ct + edge.weight;

                if (newTime < dis[next][newPower]) {
                    dis[next][newPower] = newTime;
                    pq.offer(new State(next, newPower, newTime));
                }
            }
        }

        long minTime = INF;
        int maxPower = -1;

        for (int p = 0; p <= power; p++) {
            if (dis[target][p] < minTime) {
                minTime = dis[target][p];
                maxPower = p;
            } else if (dis[target][p] == minTime) {
                maxPower = Math.max(maxPower, p);
            }
        }

        if (minTime == INF) return new long[]{-1, -1};

        return new long[]{minTime, maxPower};
    }
}