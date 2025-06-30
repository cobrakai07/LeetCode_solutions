class Dsu {
    int[] parent;
    int[] size;

    Dsu(int s) {
        size = new int[s];
        parent = new int[s];

        for (int i = 0; i < s; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find_ulp(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find_ulp(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = find_ulp(u);
        int ulp_v = find_ulp(v);
        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {

        Dsu dsu = new Dsu(grid.length * grid[0].length);

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int node = i * (grid[0].length) + j;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                            continue;
                        if (grid[nx][ny] == 1) {
                            int nodeAdj = nx * (grid[0].length) + ny;
                            dsu.unionBySize(node, nodeAdj);
                        }
                    }
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int currentArea = 1;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                            continue;
                        if (grid[nx][ny] == 1) {
                            int nodeAdj = nx * grid[0].length + ny;
                            int ulp = dsu.find_ulp(nodeAdj);
                            if (!set.contains(ulp)) {
                                set.add(ulp);
                                currentArea += dsu.size[ulp];
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int node = i * grid[0].length + j;
                    int ulp = dsu.find_ulp(node);
                    maxArea = Math.max(maxArea, dsu.size[ulp]);
                }
            }
        }

        // System.out.println(Arrays.toString(dsu.parent));
        return maxArea;

    }
}