class Pair{
    int node;
    long cost;
    Pair(int node, long cost)
    {
        this.node=node;
        this.cost=cost;
    }
    public String toString()
    {
        return "Node:"+this.node+" Cost:"+this.cost;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++)
        {
            List<Pair>list=adjList.get(roads[i][0]);
            list.add(new Pair(roads[i][1],roads[i][2]));
            list=adjList.get(roads[i][1]);
            list.add(new Pair(roads[i][0],roads[i][2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare( a.cost,b.cost));
        long[]dist=new long[n];
        int []reached=new int[n];
        int mod = (int)(1e9+7);
        
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(reached,0);
        dist[0]=0;
        reached[0]=1;

        pq.offer(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            int currNode=p.node;
            long currCost=p.cost;

            List<Pair>adjNodes=adjList.get(currNode);
            for(int i=0;i<adjNodes.size();i++)
            {
                Pair adjNode=adjNodes.get(i);
                int node=adjNode.node;
                long cost=adjNode.cost;
                if(dist[node]>currCost+cost)
                {
                    dist[node]=currCost+cost;
                    reached[node]=reached[currNode];
                    pq.offer(new Pair(node,dist[node]));
                }
                else if(dist[node]==currCost+cost)
                {
                    reached[node]=(reached[node]+reached[currNode])%mod;
                }
            }
        }
        return reached[n-1];
    }
}