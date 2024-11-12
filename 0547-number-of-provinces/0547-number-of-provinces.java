class Solution {
  public void dfs(int idx,ArrayList<ArrayList<Integer>>adjList,int[]visited)
  {
    if(visited[idx]==1)return;

    visited[idx] = 1;

        for(int i=0;i<adjList.get(idx).size();i++)
        {
          if(visited[adjList.get(idx).get(i)]==0)
          {
            dfs( adjList.get(idx).get(i) , adjList, visited);
          }
        }

  }

    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
          ArrayList<Integer>temp=new ArrayList<>();
          adjList.add(temp);
        }
 
        for(int i=0;i<isConnected.length;i++)
        {
          
          for(int j=0;j<isConnected.length;j++)
          {
            if(i==j)continue;
            if(isConnected[i][j]==1)
            {
              ArrayList<Integer>temp=adjList.get(i);
              temp.add(j);
            }
          }
        }

        int []visited=new int[isConnected.length];
        int ans=0;
        for(int i=0;i<visited.length;i++)
        {
          if(visited[i]==0)
          {
             dfs(i,adjList,visited);
             ans++;
          }
        }
        // System.out.println(adjList);
        return ans;

    }
}
