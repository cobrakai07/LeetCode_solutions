class Solution {
    public boolean rotateString(String s, String goal) {
       StringBuilder sb = new StringBuilder(s);
       int count=0;
       if(sb.toString().equals(goal))return true;
       while(count!=s.length()) 
       {
        count++;
        char ch= sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(ch);
        // System.out.println(sb);
        if(sb.toString().equals(goal))return true;
       }
       return false;
    }
}