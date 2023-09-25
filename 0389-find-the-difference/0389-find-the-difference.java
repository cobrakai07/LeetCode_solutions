class Solution {
    public char findTheDifference(String s, String t) {
       int f=0;
       for(int i=0;i<s.length();i++)
       {
           f=f+(int)s.charAt(i);
       }
       int se=0;
       for(int i=0;i<t.length();i++)
       {
           se=se+(int)t.charAt(i);
       }
       f=se-f;
       char ans=(char)f;
       return ans;
    }
}