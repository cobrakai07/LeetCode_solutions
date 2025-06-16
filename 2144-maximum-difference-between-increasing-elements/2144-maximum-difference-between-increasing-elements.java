class Solution {
    public int maximumDifference(int[] nums) {
        int[]min=new int[nums.length];
        int[]max=new int[nums.length];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min[i-1])min[i]=nums[i];
            else min[i]=min[i-1];
        }
        max[max.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>max[i+1])max[i]=nums[i];
            else max[i]=max[i+1];
        }  
        // System.out.println(Arrays.toString(min));
        // System.out.println(Arrays.toString(max));

        int i=0;
        int maxDiff = -1;
        while(i<nums.length){
            if(min[i]<max[i]){
                maxDiff=Math.max(maxDiff,max[i]-min[i]);
            }
            i++;
        }
        return maxDiff;
    }
}