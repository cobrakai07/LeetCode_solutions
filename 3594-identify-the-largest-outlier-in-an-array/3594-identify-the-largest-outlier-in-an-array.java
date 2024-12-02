class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum=0;
        int out=-1000;

        Map<Integer,Set<Integer>>mp= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mp.get(nums[i])==null){
                Set<Integer>set1= new HashSet<>();
                set1.add(i);
                mp.put(nums[i],set1);
            }else{
                Set<Integer>set1=mp.get(nums[i]);
                set1.add(i);
                mp.put(nums[i],set1);
            } 
        }
        
        for(int ii=0; ii<nums.length;ii++){
            int i=nums[ii];
            int diff=sum-(i*2);
            if(mp.get(diff)!=null &&  diff+i+(sum-diff-i)==sum){
                Set<Integer>set1=mp.get(diff);
                if(set1.contains(ii)&&set1.size()==1)continue;
                // System.out.println(STR."sum: \{sum}, diff: \{diff}, number: \{i}");
                out=Math.max(out,diff);
            }
        }

        return out;
        
    }
}