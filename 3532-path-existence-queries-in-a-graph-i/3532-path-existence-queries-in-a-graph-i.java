class DSU{
    int[]size;
    int [] parent;
    public DSU(int n){
        size = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            size[i]=1;
            parent[i]=i;
        }
    }

    public int find_ulp(int node){
        if(parent[node]==node)return node;
        return parent[node]= find_ulp(parent[node]);
    }

    public void union(int v, int u){
        int ulp_v = find_ulp(v);
        int ulp_u = find_ulp(u);

        if(ulp_v==ulp_u)return;

        if(size[ulp_v]<size[ulp_u]){
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }else{
           parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u]; 
        }
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU disjointSet = new DSU(n);
        for(int i=1;i<n;i++){
           if(Math.abs(nums[i-1]-nums[i])<=maxDiff){
            disjointSet.union(i-1,i);
           }
        }

        boolean [] ans = new boolean[queries.length];
        int idx=0;

        for(int[] query: queries){
            int u = query[0], v = query[1];
            ans[idx++]=disjointSet.find_ulp(u)==disjointSet.find_ulp(v);
        }
        return ans;
    }
}