class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int mi=1, md=1;
        int c=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                mi++;
                c=Math.max(c,mi);
            }else{
                mi=1;
            }
        }
      int  cc=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                md++;
                cc=Math.max(cc,md);
            }else{
                md=1;
            }
        }

        return Math.max(c,cc);
    }
}