class TreeAncestor {
    int LOG = 16; // max log2(n), can be 16 for n <= 1e5
    int[][] up;   // up[node][j] = 2^j-th ancestor of node

    public TreeAncestor(int n, int[] parent) {
        // compute log dynamically if needed
        LOG = (int)(Math.ceil(Math.log(n)/Math.log(2))) + 1;
        up = new int[n][LOG];

        // Fill the 0th ancestor (direct parent)
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // Fill all 2^j ancestors using DP
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                } else {
                    up[i][j] = -1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) == 1) { // if j-th bit of k is set
                node = up[node][j];
                if (node == -1) break; // no ancestor exists
            }
        }
        return node;
    }
}
