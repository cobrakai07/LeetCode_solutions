class Solution {
    public int xor(int l,int r,int[] arr)
    {
        int val=0;
        for(int i=l;i<=r;i++)
        {
            val=val^arr[i];
        }
        return val;
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int a[]=new int[queries.length];
        int idx=0;
        for(int i=0;i<queries.length;i++)
        {
            int []temp=queries[i];
            a[idx++]=xor(temp[0],temp[1],arr);
        }
        return a;
    }
}