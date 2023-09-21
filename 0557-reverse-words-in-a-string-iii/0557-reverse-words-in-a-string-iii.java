class Solution {
    public String reverseWords(String s) {
        String s2="";
        String ans="";
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
            {
                StringBuilder sb =new StringBuilder(s2);
                sb.reverse();
                String str=sb.toString();
                ans=ans+str+" ";
                s2="";
            }
           else
            {
                s2=s2+s.charAt(i);
            }
        }
        StringBuilder sb =new StringBuilder(s2);
                sb.reverse();
                String str=sb.toString();
                ans=ans+str;
        return ans;
    }
}