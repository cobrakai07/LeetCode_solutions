class Solution {
    public boolean checkRecord(String s) {
        int abs=0;
        int late=0;
        for(char c: s.toCharArray()){
            if(c=='A'){
                abs++;
                late=0;
            }
            else if(c=='L'){
                late++;
            }else{
                late=0;
            }

            if(late==3||abs>=2)return false;
        }
        return true;
    }
}