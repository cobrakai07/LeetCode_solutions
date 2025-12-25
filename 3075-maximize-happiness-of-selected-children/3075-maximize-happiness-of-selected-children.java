class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        for(int i=happiness.length-1, min = 0; i>=0 && k>0; i--,k--,min++){
            if(happiness[i]-min>=0)
                ans = ans+(happiness[i]-min);
        }
        return ans;
    }
}