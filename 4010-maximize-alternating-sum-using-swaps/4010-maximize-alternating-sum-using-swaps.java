class DSU {

    int[] size;
    int[] parent;

    public DSU(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find_ulp(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find_ulp(parent[node]);
    }

    public void union(int u, int v) {
        int ulp_u = find_ulp(u);
        int ulp_v = find_ulp(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        for(int []nodes : swaps){
            dsu.union(nodes[0],nodes[1]);
        }
        
        Map<Integer, List<Integer>> comp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find_ulp(i);
            comp.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        System.out.println(comp);
        
        // Step 3: For each component, rearrange optimally
        int[] newNums = new int[n];
        for (List<Integer> indices : comp.values()) {
            List<Integer> vals = new ArrayList<>();
            for (int idx : indices) vals.add(nums[idx]);
            
            Collections.sort(indices);
            Collections.sort(vals, (a,b)->b-a);

            int start = 0;
            int end = vals.size()-1;
            for(int i=0; i< indices.size(); i++){
                if(indices.get(i)%2==0){
                    newNums[indices.get(i)] = vals.get(start);
                    start++;
                }else{
                    newNums[indices.get(i)] = vals.get(end);
                    end--;
                }
            }
        }
        // System.out.println(Arrays.toString(newNums));
        // Step 4: Compute alternating sum
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) res += newNums[i];
            else res -= newNums[i];
        }
        
        return res;
    }
}