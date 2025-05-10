class Solution {
    public boolean fun(int i, int j, char[]s, char[]p, Boolean[][]dp){
        if(i<0 && j<0)return true;
        if(i<0&&j>=0){
            for(;j>=0;j--){
                if(p[j]!='*')return false;
            }
            return true;
        }
        if((j<0 && i>=0))return false;
        if(dp[i][j]!=null)return dp[i][j];
        if(p[j]=='*'){
            boolean a =fun(i-1,j,s,p,dp);
            boolean b =fun(i,j-1,s,p,dp);
            return dp[i][j]= a||b;
        }else{
            if(p[j]==s[i] || p[j]=='?'){
                return dp[i][j]=fun(i-1,j-1,s,p,dp);
            }else{
                return dp[i][j]=false;
            }
        }
    }
    public boolean isMatch(String s, String p) {
        Boolean[][]dp= new Boolean[s.length()][p.length()];
        return fun(s.length()-1,p.length()-1,s.toCharArray(),p.toCharArray(),dp);
    }
}