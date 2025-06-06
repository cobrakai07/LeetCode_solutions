class Solution {
    public int longestValidParentheses(String s) {
        int left=0;
        int right =0;
        int max =0;
        for(char c: s.toCharArray()){
            if(c=='(')left++;
            else right++;

            if(left==right)max=Math.max(max,left+right);

            if(right>left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=s.length()-1; i>=0;i--){
            char c = s.charAt(i);
            if(c=='(')left++;
            else right++;

            if(left==right)max=Math.max(max,left+right);

            if(right<left){
                left=0;
                right=0;
            }
        }
        return max;
    }
}