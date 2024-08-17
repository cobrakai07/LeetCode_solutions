class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            else return a[0]-b[0];
        });
        List<int[]>ans = new ArrayList<>();
        int pre=intervals[0][1];
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(pre<intervals[i][0]){
                ans.add(intervals[i]);
                pre=intervals[i][1];
            }else{
                int [] arr= ans.get(ans.size()-1);
                int start=Math.min(arr[0],intervals[i][0]);
                int end=Math.max(arr[1],intervals[i][1]);
                arr[0]=start;
                arr[1]=end;
                pre=end;
            }
        }
        // ans.forEach(q->System.out.print("["+q[0]+","+q[1]+"] "));
        return ans.toArray(new int[ans.size()][]);
        // return intervals;
    }
}