class Solution {
   
    public int findChampion(int n, int[][] edges) {
   
    int[]indeg=new int[n];

    for(int i=0;i<edges.length;i++)
        indeg[edges[i][1]]++;
       
    int count=0;

    for(int i=0;i<n;i++)
    {
        if(indeg[i]==0)
         count++;
    }
    if(count>1)return -1;

    for(int i=0;i<n;i++)
    {
        if(indeg[i]==0)
        return i;
    }

    return 69696969;
        
        
    }
}