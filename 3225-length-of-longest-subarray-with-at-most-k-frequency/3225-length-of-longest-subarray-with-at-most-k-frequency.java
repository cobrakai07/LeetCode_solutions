class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer>mp = new HashMap<>();
        int s=0, e=0, max=0;
        while(e<nums.length){
            
            if(mp.get(nums[e])==null || mp.get(nums[e])<=k){
                mp.put( nums[e], mp.getOrDefault(nums[e],0)+1 );
                if(mp.get(nums[e])<=k){max=Math.max(max,e-s+1);}
                else{
                    while(mp.get(nums[e])>k){
                    mp.put( nums[s], mp.get(nums[s])-1 );
                    s++;
                }
                }
                // System.out.println(mp+" "+s+","+e+" --"+max);
                e++;
            }else{
                while(mp.get(nums[e])>k){
                    mp.put( nums[s], mp.get(nums[s])-1 );
                    s++;
                }
            }
        }
        return max;
    }
}