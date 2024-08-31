class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String s1=num1+"";
        String s2=num2+"";
        String s3=num3+"";

        while(s1.length()!=4)s1=0+s1;
        while(s2.length()!=4)s2=0+s2;
        while(s3.length()!=4)s3=0+s3;

        String ans="";

        for(int i=0; i<4; i++){
            // System.out.println(STR."\{s1}  \{s2}  \{s3}");
            int as1=s1.charAt(i);
            int as2=s2.charAt(i);
            int as3=s3.charAt(i);

            int max=Math.min(Math.min(as1,as2),as3);

            char ch= (char)max;
            ans=ans+ch;
        }

        return Integer.parseInt(ans);
    }
}