class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find_ulp(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find_ulp(parent[node]);
    }

    void union(int u, int v) {
        int ulp_v = find_ulp(v);
        int ulp_u = find_ulp(u);
        if (ulp_v == ulp_u)
            return;
        if (size[ulp_v] < size[ulp_u]) {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
}

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int degree[] = new int[n];
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dsu.find_ulp(i);
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < dsu.parent.length; i++) {
            List<Integer> list = map.get(dsu.parent[i]);
            list.add(i);
        }

        int count = 0;

        for (int node : map.keySet()) {
            List<Integer> list = map.get(node);
            int size = list.size();
            if (size == 0)
                continue;
            if (size == 1 || size == 2) {
                count++;
                continue;
            }
            boolean flag = true;
            for (int i : list) {
                if (degree[i] < size - 1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }

        return count;

    }
}