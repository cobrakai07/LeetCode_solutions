class Pair{
    int cost;
    int node;
    Pair(int node, int cost)
    {
        this.cost=cost;
        this.node=node;
    }
}
class Graph {
    List<List<Pair>>adjList;
    public Graph(int n, int[][] edges) {
        adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            // List<Pair>list=
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            int arr[]=edges[i];
            // int node=arr[0];
            // int goToNode=arr[1];
            // int cost=arr[2];

            List<Pair>list=adjList.get(arr[0]);
            list.add(new Pair(arr[1],arr[2]));

        }
    }
    
    public void addEdge(int[] edge) {
        List<Pair>list=adjList.get(edge[0]);
        list.add(new Pair(edge[1],edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair>pq=new PriorityQueue<>( (x,y) -> x.cost - y.cost );
        int dis[]=new int[adjList.size()];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[node1]=0;
        pq.offer(new Pair(node1,0));

        while(pq.size()!=0)
        {
            Pair p=pq.poll();
            int dist=p.cost;
            int node=p.node;

            for(int i=0;i<adjList.get(node).size();i++)
            {
                int nodeAdj=adjList.get(node).get(i).node;
                int nodeAdjDis=adjList.get(node).get(i).cost;

                if(nodeAdjDis+dist< dis[nodeAdj])
                {
                    dis[nodeAdj]=nodeAdjDis+dist;
                    pq.offer(new Pair(nodeAdj,nodeAdjDis+dist));
                }
            }
        }

        if(dis[node2]==Integer.MAX_VALUE)return -1;
        
        return dis[node2];
        
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */