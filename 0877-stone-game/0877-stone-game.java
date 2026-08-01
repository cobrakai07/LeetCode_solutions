class Solution {
    public boolean fun(int left, int right, int p1, int p2,  boolean p1Turn , int[] nums){
        if(p1>p2){
            return p1>p2;
        }
        if(p1Turn){
            return fun(left+1,right,nums[left] + p1, p2, false, nums) ||  fun(left,right-1,nums[right] + p1, p2, false, nums);
        }else{
            return fun(left+1,right, p1,nums[left] + p2, true, nums) &&  fun(left,right-1, p1, nums[right] + p2, true, nums);
        }
    }
    public boolean stoneGame(int[] piles) {
        return fun(0,piles.length-1,0,0,true,piles);
    }
}