class Solution {
     Set<Integer>component=new HashSet<>();
     int[]vis;
    public boolean valid(Set<Integer>set,List<List<Integer>>adj)
    {
        Iterator<Integer>it=set.iterator();
        while(it.hasNext())
        {
            int node=it.next();
            if(adj.get(node).size()!=set.size()-1)
                return false;
        }
        return true;
    }
    public void dfs(int node, List<List<Integer>>adj, Set<Integer>v)
    {
        if(v.contains(node))return;
        vis[node]=1;
        v.add(node);
        component.add(node);
        List<Integer>list=adj.get(node);
        for(int i=0;i<list.size();i++)
        {
            dfs(list.get(i), adj, v);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        vis=new int[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int []i: edges)
        {
            List<Integer>l=adj.get(i[0]);
            l.add(i[1]);
            l=adj.get(i[1]);
            l.add(i[0]);
        }
        Map<Integer,Set<Integer>>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1)continue;
            component=new HashSet<>();
            dfs(i,adj, new HashSet<>());

            if(component.size()>0)
                mp.put(i,component);
                
        }

        int ans=0;
        for(int k: mp.keySet())
        {
            Set<Integer>comp=mp.get(k);
            if(valid(comp,adj)) ans++;
        }
        // System.out.println(mp);
        return ans;
    }
}
