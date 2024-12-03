class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(idx<spaces.length && spaces[idx]==i){
                sb.append(" ");
                sb.append(c);
                idx++;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}