class Solution {
    class Edge{
        int node;
        int cost;
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        public String toString(){
            return "Node: "+node+", Cost: "+cost;
        }
    }
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int[] road: roads){
            adjList.get(road[0]-1).add(new int[]{road[1]-1,road[2]});
            adjList.get(road[1]-1).add(new int[]{road[0]-1,road[2]});
        }

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        pq.offer(new Edge(0,Integer.MAX_VALUE));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int currNode = edge.node;
            int currMinCost = edge.cost;

            if(dis[currNode]<currMinCost)continue;

            for(int [] arr: adjList.get(currNode)){
                int adjNode = arr[0], minCost = arr[1];
                if(dis[adjNode] > Math.min(minCost,currMinCost)){
                    dis[adjNode] = Math.min(minCost,currMinCost);
                    pq.offer(new Edge(adjNode,Math.min(minCost,currMinCost)));
                }
            }

        }
        // System.out.println(Arrays.toString(dis));
        return dis[n-1];
    }
}