class Solution {
    public void toposort(int num,int[]vis,int[][]edges,Stack<Integer>stk)
    {
        if(vis[num]==1)return;
        vis[num]=1;
        for(int i=0;i<edges.length;i++)
        {
            int arr[]=edges[i];
            if(arr[0]==num)
               toposort(arr[1],vis,edges,stk);
        }
        stk.push(num);
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>>ans=new ArrayList<>();
         List<Set<Integer>>setList=new ArrayList<>();
        Stack<Integer>stk=new Stack<>();
        int[]vis=new int[n];

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
             toposort(i,vis,edges,stk);
        }
   
        List<Integer>topoList=new ArrayList<>();

        while(!stk.isEmpty())
           topoList.add(stk.pop());
        //System.out.println(topoList);
        
        for(int i=0;i<n;i++)
            setList.add(new HashSet<>());

         for(int idx=0;idx<n;idx++)
         {
            Set<Integer>set=setList.get(topoList.get(idx));
            for(int i=0;i<edges.length;i++)
             {
                int arr[]=edges[i];
                if(arr[1]==topoList.get(idx))
                {
                    set.add(arr[0]);
                    Set<Integer>setOfParent=setList.get(arr[0]);
                    Iterator<Integer>it=setOfParent.iterator();
                    while(it.hasNext())
                       set.add(it.next());
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            List<Integer>l=new ArrayList<>(setList.get(i));
            Collections.sort(l);
            ans.add(l);
        }
           
        
        
        return ans;
    }
}