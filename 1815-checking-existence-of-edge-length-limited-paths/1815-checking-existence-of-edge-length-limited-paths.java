class Dsu {
    int[] p, s;

    Dsu(int n) {
        p = new int[n];
        s = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            s[i] = 1;
        }
    }

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        if (s[xr] < s[yr]) {
            p[xr] = yr;
            s[yr] += s[xr];
        } else {
            p[yr] = xr;
            s[xr] += s[yr];
        }
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] myQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            myQueries[i][0] = queries[i][0];
            myQueries[i][1] = queries[i][1];
            myQueries[i][2] = queries[i][2];
            myQueries[i][3] = i; 
        }

        Arrays.sort(myQueries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] result = new boolean[queries.length];
        Dsu dsu = new Dsu(n);

        int edgeIndex = 0;
        for (int i = 0; i < myQueries.length; i++) {
            int u = myQueries[i][0], v = myQueries[i][1], limit = myQueries[i][2], idx = myQueries[i][3];

            
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                dsu.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }

            result[idx] = dsu.find(u) == dsu.find(v);
        }

        return result;
    }
}
