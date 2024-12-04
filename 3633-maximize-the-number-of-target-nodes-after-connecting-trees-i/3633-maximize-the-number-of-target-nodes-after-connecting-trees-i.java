record Pair(int val, int tree){}
class Solution {
    public int bfs(int node, int k, int[]vis, List<List<Pair>>list){
        ArrayDeque<int[]>q= new ArrayDeque<>();
        Set<Integer>set= new HashSet<>();
        q.offer(new int[]{node,k});
        
        while(!q.isEmpty()){
            int []n = q.poll();
            if(vis[n[0]]==1 || n[1]==0)continue;
            vis[n[0]]=1;
            set.add(n[0]);
            for(Pair p: list.get(n[0])){
                int an=p.val();
                q.add(new int[]{an,n[1]-1});
            }
        }
        // System.out.println(set);
        return set.size();
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Pair>>list1=new ArrayList<>();
        List<List<Pair>>list2=new ArrayList<>();
        for(int i=0;i<=edges1.length;i++)
            list1.add(new ArrayList<>());
        for(int i=0;i<=edges2.length;i++)
            list2.add(new ArrayList<>());
        for(int i[]: edges1){
            int v=i[0], u=i[1];
            list1.get(v).add(new Pair(u,1));
            list1.get(u).add(new Pair(v,1));
        }
        for(int i[]: edges2){
            int v=i[0], u=i[1];
            list2.get(v).add(new Pair(u,1));
            list2.get(u).add(new Pair(v,1));
        }
        // System.out.println(list1);
        // System.out.println(list2);
      
        int []dis1= new int[list1.size()];
        for(int i=0;i<list1.size();i++){
            int []vis=new int[list1.size()];
            dis1[i]= bfs(i,k+1,vis,list1);
        }

        
        int max=0;
        for(int i=0;i<list2.size();i++){
            int []vis=new int[list2.size()];
            max= Math.max(max, bfs(i,k,vis,list2));
        }
        
        int []ans= new int[list1.size()];
        for(int i=0;i<list1.size();i++){
            ans[i]=dis1[i]+max;
        }
        
        // System.out.println(Arrays.toString(dis1));
        // System.out.println(Arrays.toString(dis2));

        return ans;
    }

}