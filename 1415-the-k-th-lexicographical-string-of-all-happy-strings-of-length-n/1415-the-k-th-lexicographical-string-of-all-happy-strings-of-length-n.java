class Solution {
    String str="";
    int counter;
    public void madeString(String s, int n, int k){
        if(n==0){
            counter++;
            if(counter==k)
              str = s;
            return; 
        }
        if(s.length()==0){
            s = s+"a";
            madeString(s,n-1,k);
            s = s.substring(0,s.length()-1);

            s = s+"b";
            madeString(s,n-1,k);
            s = s.substring(0,s.length()-1);

            s = s+"c";
            madeString(s,n-1,k);
            s = s.substring(0,s.length()-1);
        }else{
            if(s.charAt(s.length()-1)!='a'){
            s = s+"a";
            madeString(s,n-1, k);
            s = s.substring(0,s.length()-1);}

            if(s.charAt(s.length()-1)!='b'){
            s = s+"b";
            madeString(s,n-1, k);
            s = s.substring(0,s.length()-1);}

            if(s.charAt(s.length()-1)!='c'){
            s = s+"c";
            madeString(s,n-1, k);
            s = s.substring(0,s.length()-1);}
        }
    }
    public String getHappyString(int n, int k) {
        madeString("",n,k);
        return str;
    }
}