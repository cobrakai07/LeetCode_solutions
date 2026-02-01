class Solution {
    public int minimumCost(int[] nums) {
        int min = nums[0];
        int n = nums.length;

        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;
        int idxSecondMin = 1;

        for(int i= 1; i<n; i++){
            if(secondMin >= nums[i]){
                thirdMin = secondMin;
                secondMin = nums[i];
            }else if(thirdMin > nums[i] && nums[i]> secondMin){
                thirdMin = nums[i];
            }
        }
     
        // System.out.println(secondMin);
        // System.out.println(thirdMin);
        return min+secondMin+thirdMin;
    }
}