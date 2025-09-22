class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];
        for(int i: nums)
            hash[i]++;
        int max = -1;
        for(int i=1;i<101;i++){
            max= Math.max(max,hash[i]);
        }
        int ans =0;
        for(int i=1;i<101;i++){
           if(hash[i]==max)ans=ans+hash[i];
        }
        return ans;
    }
}