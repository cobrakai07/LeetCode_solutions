class Solution {
    public String capitalizeTitle(String title) {
        String str="";
        String ans="";
        title=title.toLowerCase();
        for(int i=0;i<title.length();i++)
        {
            if(title.charAt(i)==' ')
            {
                if(str.length()>2)
                {
                    int ascii=str.charAt(0);
                    ascii=ascii-32;
                    char ch=(char)ascii;
                    StringBuilder sb=new StringBuilder(str);
                    sb.setCharAt(0,ch);
                    str=sb.toString();
                    ans=ans+" "+str;
                    str="";
                }
                else
                {
                    ans=ans+" "+str;
                    str="";
                }
            }
            else
            {
                str=str+title.charAt(i);
            }
        }

        if(str.length()>2)
                {
                    int ascii=str.charAt(0);
                    ascii=ascii-32;
                    char ch=(char)ascii;
                    StringBuilder sb=new StringBuilder(str);
                    sb.setCharAt(0,ch);
                    str=sb.toString();
                    ans=ans+" "+str;
                    str="";
                }
                else
                {
                    ans=ans+" "+str;
                    str="";
                }
                
        ans=ans.trim();
        return ans;
    }
}