class Solution {
    public String reverseStr(String s, int k) {

        String ans="";
        int i=0;
        int j=k;
        int count=0;

        for( ;i<s.length();i=i+k,j=i+k)
        {
            if(count%2==0)
            {
                if(j>=s.length())continue;
                StringBuilder sb= new StringBuilder(s.substring(i,j));
                sb.reverse();
                String str=sb.toString();
                ans=ans+str; 
            }
            else
            {
                if(j>=s.length())continue;
                String str2=s.substring(i,j);
                ans=ans+str2;
            }
            count++;
        }

         if(count%2==0)
        {
               StringBuilder sb= new StringBuilder(s.substring(i-k,s.length()));
               sb.reverse();
               String str=sb.toString();
               ans=ans+str; 
        }
        else
        {
            String str2=s.substring(i-k,s.length());
            ans=ans+str2;
        }
        return ans;

    }
}