record Pair(int node, double distance) {}

class Solution {
    public void dij(int source, double[] dist, boolean[] vis, List<List<Pair>> graph) {
        Arrays.fill(vis, false);
        Arrays.fill(dist, Double.NEGATIVE_INFINITY);
        dist[source] = 1;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.distance(), a.distance()));
        maxHeap.add(new Pair(source, 1));
        
        while (!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            int currNode = curr.node();
            if (vis[currNode]) continue;
            vis[currNode] = true;
            
            for (Pair edge : graph.get(currNode)) {
                int adjNode = edge.node();
                double weight = edge.distance();
                
                if (dist[currNode] * weight > dist[adjNode]) {
                    dist[adjNode] = dist[currNode] * weight;
                    maxHeap.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        boolean[] vis = new boolean[n];
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] a = edges[i];
            graph.get(a[0]).add(new Pair(a[1], succProb[i]));
            graph.get(a[1]).add(new Pair(a[0], succProb[i]));
        }
        dij(start_node, dist, vis, graph);
        return dist[end_node] == Double.NEGATIVE_INFINITY ? 0 : dist[end_node];
    }
}
