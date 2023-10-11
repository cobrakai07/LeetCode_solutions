class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>>adj=new ArrayList<>();
        int []indegree=new int[numCourses];
        List<Integer>topo=new ArrayList<>();
        Queue<Integer>q=new ArrayDeque<>();

        for(int i=0;i<numCourses;i++)
        {
            List<Integer>list=new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int []arr=prerequisites[i];
            List<Integer>list=adj.get(arr[1]);
            list.add(arr[0]);
            indegree[arr[0]]++;
        }
        
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
               q.offer(i);
        }

        while(!q.isEmpty())
        {
            int node=q.poll();
            topo.add(node);
            
            for (int it : adj.get(node))
            {
                indegree[it]--;

                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        if(topo.size()== numCourses)
        return true;
        else
        return false;

    }
}