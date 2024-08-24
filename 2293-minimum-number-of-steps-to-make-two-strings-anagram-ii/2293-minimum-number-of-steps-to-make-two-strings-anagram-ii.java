class Solution {
    public int minSteps(String s, String t) {
        int h1[]=new int[26];
        int h2[]=new int[26];
        for(char c: s.toCharArray()){
            h1[c-'a']++;
        }
        for(char c: t.toCharArray()){
            h2[c-'a']++;
        }

        int diff=0;
        for(int i=0; i<26 ;i++){
            diff+=Math.abs(h1[i]-h2[i]);
        }
        
        return diff;
    }
}