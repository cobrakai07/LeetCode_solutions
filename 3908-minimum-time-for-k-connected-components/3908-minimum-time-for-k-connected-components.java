class Dsu{
    int[]p;
    int[]s;
    Dsu(int n){
        p = new int [n];
        s = new int [n];
        for(int i=0; i< n;i++){
            p[i]=i;
            s[i]=1;
        }
    }
    int find_ulp(int node){
        if(p[node]==node)return node;
        return p[node] = find_ulp(p[node]);
    }
    boolean union(int u, int v){
        int ulp_v= find_ulp(v);
        int ulp_u= find_ulp(u);
        if(ulp_v==ulp_u)return false;
        if(s[ulp_v]<s[ulp_u]){
            p[ulp_v]=ulp_u;
            s[ulp_u]+=s[ulp_v];
        }else{
            p[ulp_u]=ulp_v;
            s[ulp_v]+=s[ulp_u];
        }
        return true;
    }
}

class Solution {
    public boolean disconnect(int n, int[][] edges,int time, int k){
        Dsu dsu1 = new Dsu(n);
        for(int [] arr : edges){
            if(arr[2]<=time)continue;
            dsu1.union(arr[0],arr[1]);
        }
        int ulp=0;
        for(int i=0; i<dsu1.p.length; i++){
            if(dsu1.p[i]==i)ulp++;
        }
        return(ulp>=k) ;
    }
    public int minTime(int n, int[][] edges, int k) {
        

        Arrays.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        if(disconnect(n,edges,0,k))return 0;
        int l=0,h=edges.length-1;
        int ans =Integer.MAX_VALUE;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(disconnect(n,edges,edges[mid][2],k)){
                ans=Math.min(ans,edges[mid][2]);
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}

