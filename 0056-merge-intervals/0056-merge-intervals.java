class Solution {
    public int[][] merge(int[][] intervals) {
        int[][]arr =intervals;
      
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        List<int[]>ans = new ArrayList<>();
        int end = arr[0][1];
        int start = arr[0][0];
        
        for(int i=1; i<arr.length; i++){
            int[]in=arr[i];
            if( in[0] <= end){
                end = Math.max(end,in[1]);
            }else{
                ans.add(new int[]{start,end});
                end = in[1];
                start = in[0];
            }
        }
   
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}