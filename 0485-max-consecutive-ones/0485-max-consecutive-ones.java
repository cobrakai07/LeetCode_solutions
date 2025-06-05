class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0;
        int max=0;
        while(j<nums.length){
            // System.out.println(i+","+j);
            if(nums[i]!=1){
                i++;
                j=i;
            }
            else{
                if(nums[j]==1){
                    
                    max=Math.max(max, j-i+1);
                    j++;
                }else{
                    i=j;
                }
            }
        }
        return max;
    }
}