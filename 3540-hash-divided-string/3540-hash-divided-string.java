class Solution {
    public String stringHash(String str, int k) {

        int s=0;
        int e=k;
        StringBuilder sb = new StringBuilder();
        while(e<=str.length()){
            String ss= str.substring(s,e);
            // System.out.println(ss);
            int sum=0;
            for(char c : ss.toCharArray()){
                sum+=(int)c-'a';
            }
            sb.append((char)(sum%26+97));
            s=e;
            e=e+k;
        }
        return sb.toString();
    }
}