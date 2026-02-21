class Solution {

    public boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

    public int partition(int i, String s, int[] dp){
        if(i == s.length()) return 0;

        if(dp[i]!=-1)return dp[i];

        int min = Integer.MAX_VALUE;

        for(int k = i; k < s.length(); k++){
            if(isPalindrome(s.substring(i, k+1))){
                int currMin = 1 + partition(k+1, s,dp);
                min = Math.min(min, currMin);
            }
        }
        return dp[i] = min;
    }

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return partition(0, s,dp) - 1; 
    }
}