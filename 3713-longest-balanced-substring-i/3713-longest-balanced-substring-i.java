class Solution {
    public boolean valid(int[] arr){
        int f = 0;
        for(int i: arr){
            if(i==0)continue;
            if(f==0){
                f=i;
            }else{
                if(f!=i)return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int []hash= new int[26];
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'a']++;
                if(valid(hash)){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}