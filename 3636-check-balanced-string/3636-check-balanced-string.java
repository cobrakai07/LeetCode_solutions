class Solution {
    public boolean isBalanced(String num) {
        int even=0;
        int odd=0;
        for(int i=0;i<num.length();i=i+2){
            even=even+Integer.parseInt(num.charAt(i)+"");
        }
        for(int i=1;i<num.length();i=i+2){
            odd=odd+Integer.parseInt(num.charAt(i)+"");
        }
        return odd==even;
    }
}