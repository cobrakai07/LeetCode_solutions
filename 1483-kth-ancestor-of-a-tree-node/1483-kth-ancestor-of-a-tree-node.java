class TreeAncestor {
    int[][] up;
    int col;
    int n;
    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        col = (int)Math.ceil(Math.log(n)/Math.log(2))+1;
        up = new int[n][col];

        for(int i=0;i<parent.length;i++){
            up[i][0]=parent[i];
        }

        for(int i=1;i<col;i++){
            for(int node =0;node<n;node++){
                if( up[node][i-1]!=-1){
                    up[node][i]= up[up[node][i-1]][i-1];
                }else{
                    up[node][i] = -1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
       
        for(int i = 0;i<col; i++){
            if((k&(1<<i))!=0){
                node = up[node][i];
                if(node==-1)return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */