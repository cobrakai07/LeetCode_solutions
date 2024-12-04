class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int p1=0;
        int p2=0;

        while(p2<str2.length() && p1<str1.length()){
            int asc1=(int)str1.charAt(p1);
            int asc2=(int)str2.charAt(p2);
            if(asc1-asc2==0){
                p2++;
                // System.out.println("0000");
                p1++;
            }else if((asc1>asc2 && 26%(asc1-asc2)==1) ||asc2-asc1==1){
                // System.out.println(asc1+","+asc2+"  -- "+(26%(asc1-asc2)));
                p1++;
                p2++;
            }else{
                p1++;
            }
        }
        return p2==str2.length();
    }
}