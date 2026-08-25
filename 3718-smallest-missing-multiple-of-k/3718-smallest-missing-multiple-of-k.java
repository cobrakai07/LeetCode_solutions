class Solution {
    // public
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        // System.out.println(set);
        for(int i=1;i<=100;i++){
            if(!set.contains(i*k))return i*k;
        }
         
        
        return k*101;
        
    }
}