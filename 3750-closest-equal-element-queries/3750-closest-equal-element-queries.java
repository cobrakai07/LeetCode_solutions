class Solution {
    public int bs(int val,List<Integer> list){
        // System.out.println(list+"   "+val);
        int l=0, h= list.size()-1;
        while(l<=h){
            int m= l+(h-l)/2;
            if(list.get(m)==val)return m;
            if(list.get(m)<val){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return -1;
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,List<Integer>>mp =new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(mp.get(nums[i])==null){
                List<Integer>list = new ArrayList<>();
                list.add(i);
                mp.put(nums[i],list);
            }else{
                List<Integer>list = mp.get(nums[i]);
                list.add(i);
                mp.put(nums[i],list);
            }
        }
        // System.out.println(mp);
        for(int a : queries){
            if(mp.get(nums[a]).size()==1){
                ans.add(-1);
                continue;
            }
            List<Integer> list = mp.get(nums[a]);
            int n = nums.length;
             int idx = Collections.binarySearch(list, a);
            int minDist = Integer.MAX_VALUE;
            int sz = list.size();

            // Get previous index (circular)
            int prevIdx = (idx - 1 + sz) % sz;
            int prev = list.get(prevIdx);
            int prevDist = (a - prev + n) % n;

            // Get next index (circular)
            int nextIdx = (idx + 1) % sz;
            int next = list.get(nextIdx);
            int nextDist = (next - a + n) % n;

            minDist = Math.min(prevDist, nextDist);
            ans.add(minDist);
            
        //    ans.add(min);
        //    System.out.println(idx);
        }
        return ans;
    }
}