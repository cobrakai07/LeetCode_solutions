class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>mp = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(mp.get(nums[i]-1)!=null){
                max=Math.max(max, i-mp.get(nums[i]-1)+1);
                
            }
            else if(mp.get(nums[i]+1)!=null){
                max=Math.max(max, i-mp.get(nums[i]+1)+1);
            }

            if(mp.get(nums[i])==null)mp.put(nums[i],i);
        }
        return max;
    }
}