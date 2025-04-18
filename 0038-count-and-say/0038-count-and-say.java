class Solution {
    String fun(String num)
    {
        String ans="";
        int idx=0;
        int count=1;
        while(idx<num.length())
        {
            
            if(idx+1<num.length()&&num.charAt(idx)==num.charAt(idx+1))
            {
                count=count+1;
                idx++;
            }
            else if(idx+1<num.length()&&num.charAt(idx)!=num.charAt(idx+1))
            {
                ans=ans+count+""+num.charAt(idx);
                count=1;
                idx++;
            }
            else if(idx+1==num.length())
            {
                ans=ans+count+""+num.charAt(idx);
                idx++;
            }
        }
        return ans;
    }
    public String countAndSay(int n) {

        if(n==1)return "1";
        
        String str="1";
        while(n!=1)
        {
            str=fun(str);
            n--;
        }
        return str;
    }
}
