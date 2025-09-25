class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][]arr =new int[intervals.length+1][2];
        for(int i=0; i<intervals.length; i++){
            arr[i]=intervals[i];
        }
        arr[arr.length-1]=newInterval;
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        List<int[]>ans = new ArrayList<>();
        int end = arr[0][1];
        int start = arr[0][0];
        for(int i=1; i<arr.length; i++){
            int[]in=arr[i];
            // System.out.println(Arrays.toString(in));
            if( in[0] <= end){
                end = Math.max(end,in[1]);
            }else{
                ans.add(new int[]{start,end});
                end = in[1];
                start = in[0];
            }
        }
        // System.out.println("===");
        ans.add(new int[]{start,end});
        // ans.forEach((a)->System.out.println(Arrays.toString(a)));
        return ans.toArray(new int[ans.size()][]);
    }
}