class Solution {
    public int fun(int i, int k, int []arr, int[] dp){
        if(i==arr.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int currMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = i, len = 1; j<Math.min(i+k,arr.length); j++, len++){
            currMax = Math.max(currMax,arr[j]);
            int currAns = (len*currMax) + fun(j+1,k,arr,dp);
            max = Math.max(currAns,max);
        }
        return dp[i] = max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return fun(0,k,arr,dp);
    }
}