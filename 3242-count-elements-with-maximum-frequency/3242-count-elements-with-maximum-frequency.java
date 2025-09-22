class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];
        for(int i: nums)
            hash[i]++;
        int max = -1;
        int ans =0;
        for(int i=1;i<101;i++){
            if(max<hash[i]){
                max=hash[i];
                ans=hash[i];
            }else if(max==hash[i]){
                ans=ans+hash[i];
            }
          
        }
        return ans;
    }
}