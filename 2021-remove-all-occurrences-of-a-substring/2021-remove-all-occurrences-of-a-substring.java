class Solution {
    public String fun(String s, String part){
        s=s.substring(0,s.indexOf(part))+s.substring(s.indexOf(part)+part.length(),s.length());
        return s;
    }
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part)!=-1){
            s=fun(s,part);
        }
        return s;
    }
}