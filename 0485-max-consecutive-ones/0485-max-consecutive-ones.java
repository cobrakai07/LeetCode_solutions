class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i=0,j=0;
        while(j<nums.length){
            if(i==j){
                if(nums[i]==0){
                    i++;j++;
                }else{
                    j++;
                }
            }
            else if(nums[j]==1){
                j++;
            }
            else{
                max=Math.max(max,j-i);
                i=j;
            }
        }
        
        max=Math.max(max,j-i);

        return max;
    }
}