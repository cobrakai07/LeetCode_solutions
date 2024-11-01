class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int p1=0,p2=0;
        int count=0;
        while(p2<s.length()){
            if(s.charAt(p1)==s.charAt(p2)){
                if(count>=2){
                    count++;
                    p2++;
                }else{
                    count++;
                    sb.append(s.charAt(p2));
                    p2++;
                }
            }else{
                count=0;
                p1=p2;
            }
        }

        return sb.toString();
    }
}