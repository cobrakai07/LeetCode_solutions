class Solution {
    public long depth(int node, List<List<Integer>> adj ){
        long d = 1;

        for(int nnode: adj.get(node)){
            d = Math.max(d,depth(nnode,adj)+1);
        }

        return d;
    }
    public void depthFill(int node, int d, int[] depth, List<List<Integer>> adj ){
        for(int nnode: adj.get(node)){
            depthFill(nnode,d+1,depth,adj);
        }
        depth[node] = d;
    }
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int _: nums)adj.add(new ArrayList<>());
        for(int i=1;i<parent.length;i++){
            adj.get(parent[i]).add(i);
        }
        long h = depth(0,adj);
        int [] dep = new int [parent.length];
        depthFill(0,1,dep,adj);
        // System.out.println(Arrays.toString(dep));
        // System.out.println(h);
        long ans = 0;

        for(int i= 0; i<dep.length; i++){
            ans = ans + (1l*nums[i]*(h-dep[i]+1));
        }
        return ans;
    }
}