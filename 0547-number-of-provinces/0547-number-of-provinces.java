class Dsu{
    int[]parent;
    int[]size;
    Dsu(int sizeOfDsu){
        parent = new int[sizeOfDsu];
        size = new int[sizeOfDsu];

        for(int i=0;i<sizeOfDsu;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findUltimateParent(int node){
        if(parent[node]==node)return node;
        return parent[node]= findUltimateParent(parent[node]);
    }

    public void unionBySize(int u, int v){
        int ulp_u= findUltimateParent(u);
        int ulp_v= findUltimateParent(v);
        
        if(ulp_v == ulp_u) return;
        if(size[ulp_v] < size[ulp_u]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        Dsu dsu = new Dsu(isConnected.length);
        for(int u=0; u < isConnected.length; u++){
            for(int v=0; v< isConnected[0].length; v++){
                if(isConnected[u][v]==1){
                    dsu.unionBySize(u,v);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<dsu.parent.length;i++){
            if(dsu.parent[i]==i)ans++;
        }
        return ans;
    }
}