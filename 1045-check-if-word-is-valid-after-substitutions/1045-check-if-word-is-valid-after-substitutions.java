class Solution {
    public String remove(String s, int i){
        return s.substring(0,i)+s.substring(i+3,s.length());
    }
    public boolean isValid(String str) {

        while(true){
            if(str.length()==0)return true;
           int i= str.indexOf("abc");
           if(i==-1)return false;
           str=remove(str,i);
        }

    }
}