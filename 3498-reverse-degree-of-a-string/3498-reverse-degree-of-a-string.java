class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            ans = ans + ((26-idx)*(i+1));
          
            // 26-(0+1) = 25 //a
            // 26-(0+2)=24 //b
            // 0+26-1//a
            // 1+26-2
            // 25+26-25//z
        }
        return ans;
    }
}