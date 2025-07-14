
class Solution {
    
    public int hamming(String s,String t){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i))
                c++;
        }
        return c;
    }
    public String fun(int i, int p,String[]words, int[] groups, String[][]dp){
        if(i==groups.length){
            return "";
        }
        if(dp[i][p+1]!=null)return dp[i][p+1];
        String pick="";
        if(p==-1){
                pick = i+" " + fun(i+1,i,words,groups,dp);
        }else{
            if(words[i].length()==words[p].length() && groups[i]!=groups[p] && hamming(words[i],words[p])==1){
                pick = i+" "+ fun(i+1,i,words,groups,dp);
            }
        }
        String npick = fun(i+1,p,words,groups,dp);

        return dp[i][p+1] = npick.length()>pick.length()?npick:pick;

    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        String[][]dp = new String[words.length][words.length+1];
        String ans = fun(0,-1,words,groups,dp);
        String str[]= ans.split(" ");
        List<String> ansList = new ArrayList<>();
        for(String i: str){
            int idx = Integer.parseInt(i);
            ansList.add(new String(words[idx]));
        }
        // System.out.println(ans);
        return ansList;
    }
}