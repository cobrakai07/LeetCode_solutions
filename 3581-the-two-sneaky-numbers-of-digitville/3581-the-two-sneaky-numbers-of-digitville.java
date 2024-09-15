class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer>mp= new HashMap<>();
        int ans[]= new int[2];
        int idx=0;
        for(int i: nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)==2)ans[idx++]=i;
        }
        return ans;
    }
}