class Solution {
    public String fun(String s){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length()-1;i++){

            int one = Integer.parseInt(s.charAt(i)+"");
            int two = Integer.parseInt(s.charAt(i+1)+"");
           
            int sum = (one +two)%10;
            sb.append(sum+"");
            }
            return sb.toString();
        
    }
    public boolean hasSameDigits(String s) {
        while(s.length()!=2){
            s=fun(s);
        }
        return (s.charAt(0)==s.charAt(1));
    }
}