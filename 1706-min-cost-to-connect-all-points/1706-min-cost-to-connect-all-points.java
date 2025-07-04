class Dsu {
    int[] parent;
    int[] size;

    Dsu(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return false;
        if (size[xr] < size[yr]) {
            parent[xr] = yr;
            size[yr] += size[xr];
        } else {
            parent[yr] = xr;
            size[xr] += size[yr];
        }
        return true;
    }
}
class Item {
    int u, v, cost;
    Item(int u, int v, int cost) {
        this.u = u; this.v = v; this.cost = cost;
    }
    public String toString() {
        return "(" + u + "-" + v + "):" + cost;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Item> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // avoid duplicate edges
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new Item(i, j, dist));
            }
        }
        
        Collections.sort(edges, (a, b) -> a.cost - b.cost);
        
        Dsu dsu = new Dsu(n);
        int totalCost = 0, edgesUsed = 0;
        
        for (Item edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                totalCost += edge.cost;
                edgesUsed++;
                if (edgesUsed == n - 1) break; // MST done
            }
        }
        
        return totalCost;
    }
}
