class Dsu{
    int []parent;
    int []size;
    Dsu(int s){
        size = new int[s];
        parent = new int[s];

        for(int i=0; i<s;i++){
            size[i]=1;
            parent[i]=i;
        }
    }

    public int find_ulp(int node){
        if(parent[node]==node)return node;
        return parent[node]= find_ulp(parent[node]);
    }

    public boolean isConnected(int u, int v){
        int ulp_v= find_ulp(v);
        int ulp_u= find_ulp(u);
        return (ulp_v==ulp_u);
    }

    public void unionBySize(int u, int v){
        int ulp_v= find_ulp(v);
        int ulp_u= find_ulp(u);
        if(ulp_v==ulp_u) return;
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
    public int makeConnected(int n, int[][] connections) {
        Dsu dsu = new Dsu(n);
        int extraEdges = 0;
        for(int []arr : connections){
            int u = arr[0], v = arr[1];
            if(!dsu.isConnected(u,v)){
                dsu.unionBySize(u,v);
            }else{
                extraEdges++;
            }
        }

        int components = 0;
        for(int i=0; i<dsu.parent.length; i++){
            if(dsu.parent[i]==i) components++;
        }

        // System.out.println(Arrays.toString(dsu.parent));
        // System.out.println(components);

        return (extraEdges>=components-1)?(components-1):-1;
    }
}