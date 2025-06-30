class Dsu{
    int[]parent;
    int[]size;
    Dsu(int s){
        parent= new int[s];
        size= new int[s];

        for(int i=0; i< s;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find_ulp(int node){
        if(parent[node]==node)return node;
        return parent[node]=find_ulp(parent[node]);
    }

    public void unionBySize(int u, int v){
        int ulp_u= find_ulp(u);
        int ulp_v= find_ulp(v);
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Dsu dsu = new Dsu(accounts.size());

        Map<String,Integer>mp = new HashMap<>();
        
        for(int i=0;i<accounts.size();i++){
            List<String>list = accounts.get(i);
            for(int j=1;j<list.size();j++){
                String s = list.get(j);
                if(mp.get(s)!=null){
                    dsu.unionBySize(i,mp.get(s));
                }else{
                    mp.put(s,i);
                }
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(int i =0; i< accounts.size(); i++)
            list.add(new ArrayList());

        Map<Integer,String>mapForAccountHolder = new HashMap<>();

        for(String s : mp.keySet()){
            int idx = mp.get(s);
            idx = dsu.find_ulp(idx);
            mapForAccountHolder.put(idx,accounts.get(idx).get(0));
            list.get(idx).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<String> l = list.get(i);
            if(l.size()>0){
                Collections.sort(l);
                l.add(0,mapForAccountHolder.get(i));
                ans.add(l);
            }
        }

        return ans;

    }
}