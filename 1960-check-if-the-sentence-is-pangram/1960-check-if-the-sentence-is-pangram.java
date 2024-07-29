class Solution {
    public boolean checkIfPangram(String sentence) {
        int h[]=new int[26];
        for(char c : sentence.toCharArray())
            h[c-'a']++;
        for(int i: h){
            if(i==0)return false;
        }
        return true;
    }
}