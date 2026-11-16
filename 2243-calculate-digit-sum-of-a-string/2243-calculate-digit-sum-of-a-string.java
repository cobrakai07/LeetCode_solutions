class Solution {
    public String add(String s){
        int sum = 0;
        for(char c: s.toCharArray()){
            int n = c-'0';
            sum += n;
        }
        return sum+"";
    }
    public boolean check(String s, int k){
        return s.length()>k;
    }
    public String digitSum(String s, int k) {
        while(check(s,k)){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i=i+k){
                if(i+k<s.length())
                sb.append(add(s.substring(i,i+k)));
                else
                sb.append(add(s.substring(i)));
            }
            s = sb.toString();
        }
        return s;
    }
}