class Solution {
    public int longestSubarray(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int ans=0;
        int p1=0,c=0;
        while(p1<nums.length){
            if(nums[p1]==max){
                c++;
                ans=Math.max(ans,c);
            }else{
                ans=Math.max(ans,c);
                c=0;
            }
            p1++;
        }
        return ans;
    }
}