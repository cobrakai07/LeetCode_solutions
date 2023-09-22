class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)return true;
        if(t.length()==0)return false;
        char []arr= s.toCharArray();
        int ptr1=0;
        int ptr2=0;
        while(ptr2<t.length())
        {
            if(t.charAt(ptr2)==arr[ptr1])
            {
                ptr1++;
                if(ptr1==arr.length)return true;
            }
               
            ptr2++;
        }
        if(ptr1!=s.length())return false;
        else return true;
    }
}