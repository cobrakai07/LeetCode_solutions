class Solution {
    public boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1)return false;
        boolean diff=false;
        int i=0, j=0;
        while(i<s1.length() || j<s2.length()){
            if(s2.length()==j&& i< s1.length()){
                if(diff)return false;
                i++;
                diff=true;
            }else if(s1.charAt(i)==s2.charAt(j)){
                i++;j++;
            }
            else{
                if(diff)return false;
                i++;
                diff=true;
            }
        }
        return i==s1.length() && j==s2.length();
    }
    public int fun(int i, int p, String [] words, int [][]dp){
        if(i==words.length){
            return 0;
        }
        if(dp[i][p+1]!=-1)return dp[i][p+1];
        int pick = 0, npick =0;
        if(p==-1 || compare(words[i],words[p])){
            pick=1+fun(i+1,i,words,dp);
        }
        npick=fun(i+1,p,words,dp);
        return dp[i][p+1]=Math.max(pick,npick);
    }
    public int longestStrChain(String[] words) {
        int[][]dp = new int[words.length][words.length+1];
        for(int []a: dp)Arrays.fill(a,-1);
        Arrays.sort(words,(str1, str2)->str1.length()-str2.length());
        return fun(0,-1,words,dp);
    }
}