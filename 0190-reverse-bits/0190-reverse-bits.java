class Solution {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while(sb.length()<32){
            sb.append('0');
        }
        // System.out.println(sb.length());
        int ans = 0;
        for(int i = sb.length()-1; i>=0; i--){
            if(sb.charAt(i)=='1')
                ans = ans + (int)Math.pow(2,sb.length()-1-i);
        }
        // System.out.println(s.length());
        return ans;
    }
}