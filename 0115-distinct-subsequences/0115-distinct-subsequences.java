class Solution {
    public int fun(int i , int j, char[] arr, char [] target, int [][] dp){

        if(j==target.length)
            return 1;

        if(i==arr.length)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int total = 0; 

        if(arr[i]==target[j]){
            total += fun(i+1,j+1,arr,target,dp);
        }
        
        total += fun(i+1,j,arr,target,dp);

        return dp[i][j] = total;
        
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] a: dp)Arrays.fill(a,-1);
        return fun(0,0,s.toCharArray(),t.toCharArray(),dp);
    }
}