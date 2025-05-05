class Solution {
    public int fun(int i, int j, char[]s1, char[]s2,Integer[][]dp){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int pick=0;
        if(s1[i]==s2[j])pick=1+fun(i-1,j-1,s1,s2,dp);
        int skipOne=fun(i-1,j,s1,s2,dp);
        int skipTwo=fun(i,j-1,s1,s2,dp);
        return dp[i][j]= Math.max(pick,Math.max(skipOne,skipTwo));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][]dp = new Integer[text1.length()][text2.length()];
        return fun(text1.length()-1,text2.length()-1,text1.toCharArray(),text2.toCharArray(),dp);
    }
}