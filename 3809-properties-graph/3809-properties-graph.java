class Solution {
    public boolean intersect(int []a, int[]b, int k){
        Set<Integer>setA = new HashSet<>();
        Set<Integer>setB = new HashSet<>();
        for(int i: a)setA.add(i);
        for(int i:b){
            if(setA.contains(i))setB.add(i);
        }
        return setB.size()>=k;
    }
    public void dfs(int i, int[]vis, int[][]graph){
        // System.out.println(i);
        if(vis[i]==1)return;
        vis[i]=1;
        int[] arr= graph[i];
        for(int j=0; j<arr.length; j++){
            if(arr[j]==1)
            dfs(j,vis,graph);
        }
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n =properties.length;
        int[][]graph= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                graph[i][j]=intersect(properties[i],properties[j],k)?1:0;
            }
        }

        // for(int []aa: graph){
        //     System.out.println(Arrays.toString(aa));
        // }

        int ans=0;
        int []vis= new int[n];
        for(int i=0; i<n ;i++){
            if(vis[i]==0){
                // System.out.println(i+" ....");
                ans++;
                dfs(i,vis,graph);
            }
        }

        return ans;

    }
}