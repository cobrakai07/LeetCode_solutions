class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>set = new HashSet<>();
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(mp.get(-nums[i]-nums[j])!=null){
                    int idx = mp.get(-nums[i]-nums[j]);
                    if(idx!=i && idx!=j){
                        List<Integer>l=new ArrayList<>();
                        l.add(nums[i]);l.add(nums[j]);l.add(nums[idx]);
                        Collections.sort(l);
                        set.add(l);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}