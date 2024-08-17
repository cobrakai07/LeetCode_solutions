class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s=0,e=intervals.length-1;
        while(s!=intervals.length){
            int arr[]=intervals[s];
            if(arr[0]>=newInterval[0] || arr[1]>=newInterval[0] )break;
            s++;
        }
        while(e!=-1){
            int arr[]=intervals[e];
            if(arr[1]<=newInterval[1] || arr[0]<=newInterval[1] )break;
            e--;
        }

        List<int[]>ans = new ArrayList<>();

        if(s<e && s<intervals.length && e!=-1){
            int idx=0;
            while(s!=idx){ans.add(intervals[idx]); idx++;}
            
            int[]sarr=intervals[s];
            int[]earr=intervals[e];
            int start= Math.min( Math.min(newInterval[0],sarr[0]), Math.min(newInterval[0],sarr[1]));
            int end= Math.max( Math.max(newInterval[1],earr[0]), Math.max(newInterval[1],earr[1]));
            ans.add(new int[]{start,end});
            idx=e+1;
            while(idx<intervals.length){ans.add(intervals[idx]); idx++;}
            ans.forEach(ee->System.out.print(ee[0]+","+ee[1]+" "));
            System.out.println("s<e");
        }
        else if(s==e && s<intervals.length && e!=-1){
            int idx=0;
            while(s!=idx){ans.add(intervals[idx]); idx++;}
            
            int[]sarr=intervals[s];
            int[]earr=intervals[e];
            int start= Math.min( Math.min(newInterval[0],sarr[0]), Math.min(newInterval[0],sarr[1]));
            int end= Math.max( Math.max(newInterval[1],earr[0]), Math.max(newInterval[1],earr[1]));
            ans.add(new int[]{start,end});
            idx=e+1;
            while(idx<intervals.length){ans.add(intervals[idx]); idx++;}
            ans.forEach(ee->System.out.print(ee[0]+","+ee[1]+" "));
            System.out.println("equals");
        }
         else{
            int idx=0;
            while(idx<intervals.length){ans.add(intervals[idx]); idx++;}
            int i=Math.max(s,e);
            ans.add(i,newInterval);
            ans.forEach(ee->System.out.print(ee[0]+","+ee[1]+" "));
            System.out.println("ajeeb");
        }
        System.out.println(s+","+e);
        return ans.toArray(new int[ans.size()][]);
        // return intervals;
    }
}