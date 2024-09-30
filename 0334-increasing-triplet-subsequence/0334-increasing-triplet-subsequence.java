 class Solution {
     public boolean increasingTriplet(int[] nums) {
         int l= nums.length;
         int[] left= new int[l];
         int[] right= new int[l];
         left[0]= nums[0];
         for(int i=1;i<l;i++){
             left[i]=Math.min(nums[i], left[i-1]);
         }
         right[l-1]= nums[l-1];
         for(int i=l-2;i>=0;i--){ 
             right[i]=Math.max(nums[i], right[i+1]);
         }
         for(int i=0;i<l;i++){ 
             if(left[i]< nums[i] && nums[i]< right[i]) 
                 return true;
         }
         return false;
     }
 }