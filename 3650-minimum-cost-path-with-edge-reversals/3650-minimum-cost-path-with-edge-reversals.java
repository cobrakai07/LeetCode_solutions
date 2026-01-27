class Solution {
    public int minCost(int n, int[][] edges) {

        List<List<int[]>>adj = new ArrayList<>();
        List<List<int[]>>adjRev = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }
           

        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adjRev.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;

        PriorityQueue<int[]>queue = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){
            int [] arr = queue.poll();
            int node = arr[0];
            int cost = arr[1];
            for(int [] nnode: adj.get(node)){
                int adjNode = nnode[0];
                int adjCost = nnode[1];
                if(cost+adjCost < dis[adjNode]){
                    dis[adjNode] = cost+adjCost;
                    queue.offer(new int[]{adjNode,dis[adjNode]});
                }
            }
            for(int [] nnode: adjRev.get(node)){
                int adjNode = nnode[0];
                int adjCost = nnode[1];
                if(cost+(adjCost*2) < dis[adjNode]){
                    dis[adjNode] = cost+(adjCost*2);
                    queue.offer(new int[]{adjNode,dis[adjNode]});
                }
            }
        }

        return dis[n-1]==Integer.MAX_VALUE? -1: dis[n-1];
    }
}