class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        int abss = Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                       min= Math.min(min,abss);
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}