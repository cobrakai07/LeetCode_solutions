class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer>mp= new HashMap<>();
        for(int i=0; i<nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int []x: operations){
            nums[mp.get(x[0])]=x[1];
            mp.put(x[1],mp.get(x[0]));
        }
        return nums;
    }
}