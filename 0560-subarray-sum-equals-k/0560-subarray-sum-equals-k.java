class Solution {
    public int subarraySum(int[] nums, int k) {
        int cs=0;
        int count=0;
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length; i++){
            cs+=nums[i];
            if(cs==k){
                count++;
            }
            if(mp.get(cs-k)!=null){
                count=count+mp.get(cs-k);
            }
          
            mp.put(cs,mp.getOrDefault(cs,0)+1);
        }
        return count;
    }
}