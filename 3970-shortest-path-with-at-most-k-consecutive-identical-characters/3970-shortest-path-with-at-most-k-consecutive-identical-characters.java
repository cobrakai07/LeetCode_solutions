record Node(int node, char c, long w, int cons) {}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] e : edges) {
            list.get(e[0]).add(new int[] { e[1], e[2] });}
        long[][] dis = new long[n][k+1];
        for(long[]aa: dis)
            Arrays.fill(aa, Integer.MAX_VALUE);
        dis[0][1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w(), b.w()));
        pq.offer(new Node(0, labels.charAt(0), 0, 1));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cnode = node.node();
            char ch = node.c();
            long cw = node.w();
            int cons = node.cons();
            if(cw>dis[cnode][cons])continue;
            for (int[] nnode : list.get(cnode)) {
                int ncon =( ch == labels.charAt(nnode[0]) )? cons + 1 : 1;
                if(ncon>k)continue;
                long nd = cw+nnode[1];
                if(nd<dis[nnode[0]][ncon]){
                    dis[nnode[0]][ncon] = nd;
                    pq.offer(new Node(nnode[0],labels.charAt(nnode[0]),nd,ncon));
                }
            }
        }

        long min = Integer.MAX_VALUE;
        for(int i=0;i<k+1;i++)
            min = Math.min(dis[n-1][i],min);
        return min==Integer.MAX_VALUE?-1:(int)min;

    }
}